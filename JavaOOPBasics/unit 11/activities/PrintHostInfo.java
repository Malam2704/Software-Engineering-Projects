package activities;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class PrintHostInfo{
    public static void main(String[] args) throws UnknownHostException {
        InetAddress local = InetAddress.getLocalHost();
        System.out.println(local.getHostName());
        System.out.println(local.getHostAddress());
    }
}