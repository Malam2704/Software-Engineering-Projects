// Mohammed Alam, Assignment 12.1
// TO make a server that tells a client the time,
// but limited to only one command per connection
// Where the user can enter TIME and recive an object of Time type,
// quit to just stop, or Error for any unknown command.
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.Scanner;

public class TimeServer implements Runnable{
    Date date = new Date();
    private final Socket socket;
    private final Scanner scanner;
    private final PrintWriter printWriter;

    // A server made with a Socket, that has it's opwn printwiter and scanner
    public TimeServer(Socket socket) throws IOException{
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
        while(true) {
            // Gets each line starting with a >>
            String line = scanner.nextLine();
            System.out.println(line);

            // If statement for the commadn user entered
            // it will break after everything, there's a quite
            // time and else, where a String of error or time will be
            // sent to the client
            if(line.equals("QUIT")){
                try{
                    Thread.sleep(1500);
                }catch(InterruptedException e){}
                break;
            }else if(line.equals("TIME")){
                printWriter.println(date); 
                printWriter.flush();
                break;
            }else{
                // Is basically our line being entered, but sent back to the user 
                printWriter.println("Error: Unknown request: " + line); 
                printWriter.flush();
                break;
            }
        }
        // extra code if I wanted to terminate the whole server
        // try {
        //     socket.close();
        //     scanner.close();
        // } catch (IOException e) {
        //     // 
        // }
    }
    public static void main(String[] args) throws IOException {
        // Establish new connection to port 13000
        ServerSocket server = new ServerSocket(13000);
        System.out.println("Waiting for a connection...");

        // While loop to let all clients in, aslong as they accept
        while (true){
            // If there is a client in the terminal, it will accept
            Socket client = server.accept();
            System.out.println("Connection received from: " + client.getInetAddress() + ":" + client.getPort());

            // Makes a new TimeClient for each terminal
            TimeServer ts = new TimeServer(client);            
            new Thread(() -> ts.run()).start();
        }

        // scanner.close();
        // server.close();
    }
}