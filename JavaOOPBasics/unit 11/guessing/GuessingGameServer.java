package guessing;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class GuessingGameServer extends Duplexer implements Runnable {
    private final GuessingGame game;

    public GuessingGameServer(GuessingGame game, Socket socket) throws IOException{
        super(socket);
        this.game = game;
    }

    public void run(){
        boolean sentinel = true;
        while(sentinel){
            String request = receive();
            String[] tokens = request.split(" ");
            switch(tokens[0]){
                case "RESTART":
                    game.restart();
                    send("RESTARTED");
                    break;
                case "QUIT":
                    game.quit();
                    send("GAME_OVER");
                    sentinel = false;
                    break;
                case "GUESS":
                    int myGuess = Integer.parseInt(tokens[1]);
                    GuessResult result = game.guess(myGuess);
                    send(result.toString());
                    break;
                default:
                    send("ERROR");
                    break;
            }
        }
    }

    public static void main(String[] args) throws IOException{
        ServerSocket server = new ServerSocket(42975);
        while(true) {
            Socket client = server.accept();
            GuessingGame game = new GuessingGameImpl();
            GuessingGameServer ggserver = new GuessingGameServer(game,client);
            new Thread(() -> ggserver.run()).start();
        }
        //server.close();
    }
}
