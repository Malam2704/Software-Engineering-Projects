package tinychat;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TinyChatServer implements Runnable{
    private final Socket socket;
    private final Scanner scanner;
    private final PrintWriter printWriter;

    // A server made with a Socket, that has it's opwn printwiter and scanner
    public TinyChatServer(Socket socket) throws IOException{
        this.socket = socket;
        InputStream input = socket.getInputStream();
        this.scanner = new Scanner(input);
        OutputStream output = socket.getOutputStream();
        this.printWriter = new PrintWriter(output);
    }

    @Override
    public void run() {
        // This is made just for the <name> has Connected
        // message, because without it, there would eb a delay in the
        // scanner, where the user's input is ahead 1 statement of our
        // scanner.nextLine
        String line = scanner.nextLine();
        System.out.println(line);
        while(true) {
            // Gets each line starting with a >>
            line = scanner.nextLine();
            System.out.println(line);

            // Splits that line into uname and other words
            // If quit it by itself would eb the 2nd word, so if there
            // is a quit then a sleep and a bnreak fromt the loop
            String[] tokens = line.split(" ");
            String uName = tokens[0];
            if(line.contains("@disConnectServer") || tokens[1].equals("Quit")){
                try{
                    Thread.sleep(1500);
                }catch(InterruptedException e){}
                break;
            }

            // Is basically our line being entered, but sent back to the user 
            printWriter.println(line); 
            printWriter.flush();
        }

        // After the loop ends a clsoign statement is given to the client
        printWriter.println("Closing"); 
        printWriter.flush();
        // Reads the disconnect server statement form the client, their last message.
        line = scanner.nextLine();
        System.out.println(line);
    }

    public static void main(String[] args) throws IOException {
        // Main method with a server and waiting
        ServerSocket server = new ServerSocket(12410);
        System.out.println("Waiting for a connection...");

        // While loop to let all clients in, aslong as they accept
        while (true){
            // If there is a client in the terminal, it will accept
            Socket client = server.accept();
            System.out.println("Connection received from: " + client.getInetAddress() + ":" + client.getPort());

            // Makes a new TinyChatClient for each terminal
            TinyChatServer tcs = new TinyChatServer(client);            
            new Thread(() -> tcs.run()).start();
        }

        // server.close();
        // client.close();
        // scanner.close();
    }
}
