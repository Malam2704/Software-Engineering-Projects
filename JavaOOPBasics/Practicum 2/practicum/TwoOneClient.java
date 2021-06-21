package practicum;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TwoOneClient implements Runnable{
    private final Socket socket;
    private final Scanner scanner;
    private final Scanner prompt;
    private final PrintWriter printWriter;
    private int score = 0;

    public TwoOneClient(Socket socket) throws IOException{
        this.socket = socket;
        InputStream input = socket.getInputStream();
        this.scanner = new Scanner(input);
        this.prompt = new Scanner(System.in);
        OutputStream output = socket.getOutputStream();
        this.printWriter = new PrintWriter(output);
    }

    @Override
    public void run() {
        boolean sentinel = true;
        while(sentinel){
            System.out.println("Player Score: " + score);

            // What I am typing and will be sending.
            String text = "";
            // if(score >= 21){
            //     String command = scanner.nextLine();
            //     System.out.println(command + " Loser!");
            //     sentinel = false;
            // }else 
            if(score >= 11 && score < 21){
                System.out.print("(H)it or (S)tay: ");
                text = prompt.nextLine();     
                printWriter.println(text);
                printWriter.flush();
                String bcommand = scanner.nextLine();
                //System.out.println(bcommand);
                if(bcommand.equals("Loser!")){
                    System.out.println("S: >> STAY");
                    System.out.println("Player Score: " + score);
                    System.out.println("You busted with a score of " + score);
                    sentinel = false;
                }else{
                    System.out.println("R: << " +bcommand);
                    String[] tokens = bcommand.split(" ");
                    if(tokens.length == 2){
                        score+= Integer.parseInt(tokens[1]);  
                    }
                }
            }else{
                String command = scanner.nextLine();
                System.out.println("R: << " +command);
                if(command.equals("You Win")){
                    System.out.print("S: >> ");
                    text = prompt.nextLine();     
                    printWriter.println(text);
                    printWriter.flush();
                }else if(command.contains("GAME_OVER")){
                    System.out.println("The Dealer Wins ");
                    System.out.print("S: >> ");
                    text = prompt.nextLine();     
                    printWriter.println(text);
                    printWriter.flush();
                }

                String[] tokens = command.split(" ");
                if(tokens.length == 2){
                    score+= Integer.parseInt(tokens[1]);  
                }
            }

            if(text.equals("BYE")){
                sentinel = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {

        // Find the port 12410 which the server should be running first.
        Socket sock = new Socket("localhost",12345);

        // Is the Connected message
        Scanner nameScanner = new Scanner(System.in);
        System.out.print("Enter your name: ");

        String name = nameScanner.nextLine();
        TwoOneClient toc = new TwoOneClient(sock);
        Thread tccThread = new Thread(toc);
        tccThread.start();

        //sock.close();
    }
}
