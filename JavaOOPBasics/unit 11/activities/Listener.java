// Day 2
package activities;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Listener{
    public static void main(String[] args) throws IOException {
        ServerSocket myServer = new ServerSocket(54321);
        System.out.println("Waiting for a connection...");
        Socket client = myServer.accept();
        System.out.println("Connection received from: " + client.getInetAddress() + ":" + client.getPort());

        InputStream in = client.getInputStream();
        Scanner scanner = new Scanner(System.in);

        while(scanner.hasNext()){
            System.out.println(scanner.nextLine());
        }

        myServer.close();
        client.close();
        scanner.close();
    }
}