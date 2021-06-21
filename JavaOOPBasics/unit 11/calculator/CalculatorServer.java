package calculator;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;

public class CalculatorServer {
    public static void main(String[] args) throws IOException {
        // Makes a new datgram socket to collect info on port 12400
        DatagramSocket dSocket = new DatagramSocket(12400);
        System.out.println("Waiting for a connection...");

        // Adds the calculator sutff
        List<BinaryOperation> OPERATIONS = new ArrayList<>(7);
        OPERATIONS.add (new Addition());
        OPERATIONS.add (new Subtraction());
        OPERATIONS.add (new Multiplication());
        OPERATIONS.add (new Division());
        OPERATIONS.add (new FloorDivision());
        OPERATIONS.add (new Exponent());
        Calculator calculator = new Calculator(OPERATIONS);
        System.out.println("Added");
        
        // So a while loop to get the byte seprate it, apply an operand
        // and run, all until the user enters quits.

        // Message is essentially going to be the message sent form the client
        String message = "";
        while(message.equals("quit") == false){
            // An empty byte being made and a data gram packet for the emtpy byte
            // the socket we made at port 240 is going to recive that empty byte that 
            // is altered in the client.
            byte[] emptybuffer = new byte[1000000];

            DatagramPacket envelope = new DatagramPacket(emptybuffer, emptybuffer.length);
            
            dSocket.receive(envelope);
            System.out.println("Byte received from " + envelope.getAddress());

            // The packet we recive is a byte, which is turned into a string
            // and split between spaces.
            byte[] bytes = envelope.getData();
            int length = bytes.length;
            message = new String(bytes,0,length);
            System.out.println(message);
            
            String result;
            String[] tokens = message.strip().split(" ");
            // if the user didn't put two saces bad request
            if (tokens.length != 3) {
                result = "error bad request";
            }else {
                // However if the user did, we jsut get the calc stuff
                // and apply it to a result that will later be sent back to the client
                // Parse the components
                try {
                    float operand1 = Float.parseFloat(tokens[0]);
                    float operand2 = Float.parseFloat(tokens[2]);
                    // Get the result as a String
                    result = "" + calculator.calculate(tokens[1], operand1, operand2);
                } catch (Exception e) {
                    // Uh-oh, something bad happened, record it as the result
                    result = "error " + e.getLocalizedMessage();
                }
            }
            // now we print the result to be sure
            System.out.println(result);

            // Now we get the client's ip, which was received form the envelope
            // or equation they sent, and we get the port too
            InetAddress returnAddress = envelope.getAddress();
            int returnPort = envelope.getPort();

            // In the port we turn that stirng back into a byte
            // then send that byte in a data packet back to the socket
            String reply = result;
            byte[] replyBytes = reply.getBytes();
            DatagramPacket replyEnvelope = new DatagramPacket(replyBytes,
                replyBytes.length,returnAddress,returnPort);
            dSocket.send(replyEnvelope);
        }
    }
}
