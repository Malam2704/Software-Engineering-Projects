package activities;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Connnector {
    public static void main(String[] args) throws UnknownHostException, IOException {
        Socket sock = new Socket("www.se.rit.edu",443);
    }
}
