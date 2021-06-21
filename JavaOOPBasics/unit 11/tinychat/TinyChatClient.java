// Mohammed Alam, Assignment 11.3
// I made it perfectly all the way upto 5, you can see it in a previous commit.
// But for some reaosn number 6, I'm not so confident in.
import java.util.Scanner;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TinyChatClient implements Runnable{
    private final Socket socket;
    private final Scanner scanner;
    private final Scanner prompt;
    private final PrintWriter printWriter;
    private final String name;

    public TinyChatClient(Socket socket,String name) throws IOException{
        // Just like the EchoClient, 2 scanners and one OutputStream
        this.socket = socket;
        InputStream input = socket.getInputStream();
        this.scanner = new Scanner(input);
        this.prompt = new Scanner(System.in);
        OutputStream output = socket.getOutputStream();
        this.printWriter = new PrintWriter(output);
        this.name = name;
    }

    @Override
    public void run() {
        // // Scanner to ask user for their name
        // Scanner nameScanner = new Scanner(System.in);
        // System.out.print("Enter your name: ");
        // String name = nameScanner.nextLine();

        // Basically for the user has connected message
        printWriter.println(name + " has Connected"); 
        printWriter.flush();

        while(true) {
            // Has these >> and user enters a message
            System.out.print(">>");
            String text = prompt.nextLine();

            // Gets the users name along with the Message
            // and sends it through
            printWriter.println(name + ": " + text);
            printWriter.flush();

            // This below is basically, what the Server is getting
            // so when the server flushes it adds to this scanner where
            // we read the next line
            String line = scanner.nextLine();
            System.out.println(line);

            // If that next line has the QWuit we stop the loop
            if(text.equals("@disConnectServer") || text.equals("Quit")){
                try{
                    Thread.sleep(1500);
                }catch(InterruptedException e){}
                break;
            }
        }

        // Last message given to the server, the disconnect.
        printWriter.println(name + " has disconnected from the server"); 
        printWriter.flush();
    }

    public static void main(String[] args) throws IOException {

        // Find the port 12410 which the server should be running first.
        Socket sock = new Socket("localhost",12410);
        // // Makes an output stream set to transfer data into the
        // // socket, and makes a print writer to send strings.
        // OutputStream out = sock.getOutputStream();
        // PrintWriter writer = new PrintWriter(out);

        // // Makes an i8npute stream to read data coming in form the port.
        // // Scanner 2 is basically gonna be a huge text that is made up of
        // // the text coming in from the server, which is a copy of our input.
        // InputStream in = sock.getInputStream();
        // Scanner scanner2 = new Scanner(in);

        // Is the Connected message
        Scanner nameScanner = new Scanner(System.in);
        System.out.print("Enter your name: ");

        String name = nameScanner.nextLine();
        TinyChatClient tcc = new TinyChatClient(sock,name);
        Thread tccThread = new Thread(tcc);
        tccThread.start();

        //sock.close();
    }   
}
