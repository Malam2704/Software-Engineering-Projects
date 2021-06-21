package activities;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Name {
    public static void main(String[] args) throws UnknownHostException, IOException {
        Socket sock = new Socket("nitron.se.rit.edu",42975);

        OutputStream output = sock.getOutputStream();
        // Scanner scanner = new Scanner(input);
        // while(scanner.hasNext()){
        //     System.out.println(scanner.nextLine());
        // }
        // scanner.close();

        PrintWriter eh = new PrintWriter(output);
        eh.println("Error 505, windows will start new update!");
        eh.flush();

        InputStream inputStream = sock.getInputStream();
        Scanner scanner = new Scanner(inputStream);
        System.out.println(scanner.nextLine());
        scanner.close();
        
        sock.close();
    }
}
