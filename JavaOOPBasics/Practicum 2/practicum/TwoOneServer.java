package practicum;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class TwoOneServer extends Duplexer implements Runnable{
    private int score = 0;
    private Random RNG = new Random();

    public TwoOneServer(Socket socket) throws IOException {
        super(socket);
        //TODO Auto-generated constructor stub
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        boolean sentinel = true;
        System.out.println("Welcome to 21, you get a set of cards below");
        while(sentinel){
            int cardNum = RNG.nextInt(10) + 1;
            send("DEAL " + cardNum);
            score+= cardNum;
            if(score > 21){
                send("GAME_OVER You Busted with a score of " + score);
                int inty = score + RNG.nextInt(10) + 1;
                send(inty);
            }else if(score == 21){
                send("You Win");
            }

            String line = "";
            if(score >= 11){
                line = read();
                if(line.equals("S")){
                    send("Loser!");
                }
            }
            // else if(score >= 21){
            //     send("GAME+OVER You Busted with a score of" + score);
            //     sentinel = false;   
            // }

            if(line.equals("BYE")){
                sentinel = false;
            }
        }
    }

    public static void main(String[] args) throws IOException{
        ServerSocket server = new ServerSocket(12345);
        System.out.println("Waiting for a connection...");

        while(true) {
            Socket client = server.accept();
            System.out.println("Connection Establsihed");
            System.out.println("Connection received from: " + client.getInetAddress() + ":" + client.getPort());

            TwoOneServer tos = new TwoOneServer(client);
            new Thread(() -> tos.run()).start();
        }
    }
}
