// Mohammed Alam, Assignment 11.2
// We need to make a calcualtor thorught
// the networking modules with a cleint and server.
// Where the client enters what it needs the server to do
// and the server sends that data the cleint wants.
package calculator;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CalculatorClient {
    public static void main(String[] args) throws IOException {
        // New socket for connectiosn is made
        DatagramSocket dSocket = new DatagramSocket();

        // scanner stuff
        Scanner in = new Scanner (System.in);

        // While loop to ask the user to enter
        // an equation all the while getting the result
        // back from the server.
        String input = "";
        while(input.equals("quit") == false){
            // Turns the string input the user entered
            // into a byte
            System.out.print ("Enter math operation (or nothing to exit): ");
            input = in.nextLine();
            byte[] bytes = input.getBytes();

            // turns that byte into a packet with an IP and a port
            // and sends it.
            DatagramPacket dPacket= new DatagramPacket(bytes, bytes.length,InetAddress.getLocalHost(),12400);
            dSocket.send(dPacket);

            // THIS IS WHEN THE SERVER SENDS THE ANSWER BACK
            // A new byte is made for the port to receive data
            // so the byte for the answer can be sent
            byte[] emptybuffer = new byte[1000000];
            DatagramPacket empty = new DatagramPacket(emptybuffer,emptybuffer.length);
            dSocket.receive(empty);

            // When the byte is sent it's turned into a stirng and printed
            byte[] data = empty.getData();
            int length = empty.getLength();
            String reply = new String(data,0,length);
            System.out.println(reply);
        }
    }
}
