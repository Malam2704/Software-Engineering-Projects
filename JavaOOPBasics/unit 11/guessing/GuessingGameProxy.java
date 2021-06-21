package guessing;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class GuessingGameProxy extends Duplexer implements GuessingGame{
    public GuessingGameProxy(Socket socket) throws IOException{
        super(socket);
    }

    @Override
    public void restart(){
        send("RESTART");
        String response = receive();
        if(!response.equals("RESTARTED")){
            throw new IllegalStateException("Bade respone!");
        }
    }
    
    @Override 
    public GuessResult guess(int number){
        send("GUESS " + number);
        String response = receive();
        switch(response){
            case "TOO_LOW":
                return GuessResult.TOO_LOW;
            case "TOO_HIGH":
                return GuessResult.TOO_HIGH;
            case "CORRECT":
                return GuessResult.CORRECT;
            case "OUT_OF_GUESSES":
                return GuessResult.OUT_OF_GUESSES;
            default:
                throw new IllegalStateException("Bade respone!");
        }
    }

    @Override 
    public void quit(){
        send("QUIT");
        String response = receive();
        if(!response.equals("RESTARTED")){
            throw new IllegalStateException("Bade respone!");
        }
    }

    public static void main(String[] args) throws UnknownHostException, IOException{
        Socket socket = new Socket("localhost",42975);
        GuessingGame proxy = new GuessingGameProxy(socket);
        GamePlayer player = new GamePlayer(proxy);
        player.playTheGame();
    }
}
