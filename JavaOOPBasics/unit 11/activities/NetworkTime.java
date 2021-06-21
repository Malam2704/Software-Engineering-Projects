package activities;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.Scanner;

public class NetworkTime {
    public static void main(String[] args) throws IOException {
        Socket eee =  new Socket("time.nist.gov",13);

        InputStream input = eee.getInputStream();
        Scanner scanner = new Scanner(input);
        while(scanner.hasNext()){
            System.out.println(scanner.nextLine() + " ");
        }
        scanner.close();
        eee.close();
    }
}
