package activities;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class SearchPrinter {
    public static void main(String[] args) throws IOException {
        // HTTP Standard port of 80, https 443, if we don't specify port,
        // the url's will assume these are your ports, Tellnet is 23
        String mySite = "https://people.rit.edu:443/ma3655/ISTE240/";
        URL u = new URL(mySite);
        URLConnection uCon = u.openConnection();
        uCon.connect();

        InputStream input = uCon.getInputStream();
        Scanner scanner = new Scanner(input);
        while(scanner.hasNext()){
            System.out.println(scanner.nextLine());
        }
        scanner.close();
    }
}
