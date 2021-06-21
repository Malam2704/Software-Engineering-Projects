import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class HttpGet {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("www.npr.org", 80);

        String request = "GET / HTTP/1.1\r\n" +
            ""

        OutputStream out = socket.getOutputStream();
        out.write(request.getBytes());
        out.flush();

        Scanner scanner = 
    }
}
