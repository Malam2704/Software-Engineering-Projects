package activities;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class EchoClient {
    public static void main(String[] args) throws UnknownHostException, IOException {
        Socket sock = new Socket("localhost",54321);

        OutputStream out = sock.getOutputStream();
        PrintWriter writer = new PrintWriter(out);

        InputStream in = sock.getInputStream();
        Scanner scanner = new Scanner(in);

        Scanner prompt = new Scanner(System.in);

        while(true) {
            System.out.print(">>");
            String text = prompt.nextLine();
            writer.println(text);
            writer.flush();

            String line = scanner.nextLine();
            System.out.println(line);

            // The text is basically our input, what we typed
            // into the terminal.
            if(text.equals("quit")){
                break;
            }
        }

        sock.close();
    }
}
