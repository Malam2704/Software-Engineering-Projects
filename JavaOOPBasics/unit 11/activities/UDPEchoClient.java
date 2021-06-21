package activities;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UDPEchoClient {
    public static void main(String[] args) throws IOException {
        DatagramSocket dSocket = new DatagramSocket();
        String message = "Help send horse";
        byte[] bytes = message.getBytes();

        DatagramPacket dPacket= new DatagramPacket(bytes, bytes.length, InetAddress.getLocalHost(), 54321);
        
        dSocket.send(dPacket);

        byte[] emptybuffer = new byte[1024];
        // watch lecture ntoes for this
        DatagramPacket empty = new DatagramPacket(emptybuffer,emptybuffer.length);
        dSocket.receive(empty);

        byte[] data = empty.getData();
        int length = empty.getLength();
        String reply = new String(data,0,length);
        System.out.println(reply);
    }
}
