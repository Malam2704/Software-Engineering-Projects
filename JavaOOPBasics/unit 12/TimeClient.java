import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

// Besides the bad command same comments from BadTimeClient
public class TimeClient {
    public static void main(String[] args) throws IOException {
        Socket sock = new Socket("localhost",13000);

        OutputStream out = sock.getOutputStream();
        PrintWriter writer = new PrintWriter(out);

        InputStream in = sock.getInputStream();
        Scanner scanner = new Scanner(in);

        Scanner prompt = new Scanner(System.in);


        while(true) {
            
            System.out.print(">>");
            System.out.println("TIME");
            // String text = prompt.nextLine();
            writer.println("TIME");
            writer.flush();

            String line = scanner.nextLine();
            System.out.println(line);

            // The text is basically our input, what we typed
            // into the terminal.
            break;
        }

        sock.close();
    }
}
