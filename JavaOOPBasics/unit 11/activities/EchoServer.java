package activities;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class EchoServer {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(54321);
        System.out.println("Waiting for a connection...");
        Socket client = server.accept();
        System.out.println("Connection received from: " + client.getInetAddress() + ":" + client.getPort());

        InputStream in = client.getInputStream();
        Scanner scanner = new Scanner(in);

        OutputStream out = client.getOutputStream();
        PrintWriter writer = new PrintWriter(out);

        // watch lecture notes
        while(true) {
            String line = scanner.nextLine();
            System.out.println(line);

            writer.println("Reply: " + line); 
            writer.flush();

            if(line.equals("quit")){
                break;
            }
        }

        server.close();
        client.close();
        scanner.close();
    }
}
