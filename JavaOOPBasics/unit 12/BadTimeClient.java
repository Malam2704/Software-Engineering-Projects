import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class BadTimeClient {
    public static void main(String[] args) throws IOException {
        // Basic stuff needed for any client, a socket in the port 
        // , and output stream to submit info to server, inputstream to get info
        //  to the server, and a prompt to enter our commands.
        Socket sock = new Socket("localhost",13000);

        OutputStream out = sock.getOutputStream();
        PrintWriter writer = new PrintWriter(out);

        InputStream in = sock.getInputStream();
        Scanner scanner = new Scanner(in);

        Scanner prompt = new Scanner(System.in);


        while(true) {
            // The print line for the >>bad command
            System.out.print(">>");
            System.out.println("TIMEX");

            // Sends to Server's scanner
            writer.println("TIMEX");
            writer.flush();

            // reads input from server and prints it.
            String line = scanner.nextLine();
            System.out.println(line);
            break;
        }

        sock.close();
    }
}