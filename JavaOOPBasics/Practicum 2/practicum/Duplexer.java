package practicum;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Duplexer {
    private Socket socket;
    private Scanner in;
    private PrintWriter out;
    
    public Duplexer(Socket socket)  throws IOException {
        this.socket = socket;
        in = new Scanner (socket.getInputStream ());
        out = new PrintWriter (socket.getOutputStream ());
    }

    public void close() {
        try {
            socket.close();
            out.close();
            in.close();
        } catch(IOException ioe) {
            // squash
        }
    }

    public void send(String message) {
        System.out.println("S: >> " + message);
        out.println(message);
        out.flush();
    }

    public String read() {
        String line = in.nextLine();
        System.out.println("R: << " + line);
        return line;
    }

}
