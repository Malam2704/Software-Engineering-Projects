package activities;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UDPEchoServer {
    public static void main(String[] args) throws IOException {
        DatagramSocket dSocket = new DatagramSocket(54321);
        System.out.println("Waiting for a connection...");
        byte[] emptybuffer = new byte[1024];

        DatagramPacket envelope = new DatagramPacket(emptybuffer, emptybuffer.length);
        
        dSocket.receive(envelope);

        byte[] bytes = envelope.getData();
        int length = bytes.length;
        String message = new String(bytes,0,length);
        System.out.println(message);
        
        // 
        // String result;
        // String[] tokens = message.strip().split(" ");
        // System.out.println(tokens);
        // if (tokens.length != 3) {
        //     result = "error bad request";
        // }else {
        //     // Parse the components
        //     try {
        //         float operand1 = Float.parseFloat(tokens[0]);
        //         float operand2 = Float.parseFloat(tokens[2]);
        //         // Get the result as a String
        //         result = "" + calculator.calculate(tokens[1], operand1, operand2);
        //     } catch (Exception e) {
        //         // Uh-oh, something bad happened, record it as the result
        //         result = "error " + e.getLocalizedMessage();
        //     }
        // }
        // System.out.println(result);
        //

        InetAddress returnAddress = envelope.getAddress();
        int returnPort = envelope.getPort();

        String reply = "Reply: Help on the way";
        byte[] replyBytes = reply.getBytes();
        DatagramPacket replyEnvelope = new DatagramPacket(replyBytes,
            replyBytes.length,returnAddress,returnPort);
        dSocket.send(replyEnvelope);
    }
}
