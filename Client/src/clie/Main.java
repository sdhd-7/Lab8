package clie;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Main {
    public static void main(String[] args) throws IOException {
        byte[] arr = {0,1,2,3,4,5,6,7,8,9}, arr2 = new byte[2048];
        int len = arr.length;
        DatagramSocket ds; DatagramPacket dp;
        InetAddress host; int port;
        ds = new DatagramSocket();
        host = InetAddress.getLocalHost();
        port = 1337;

        dp = new DatagramPacket(arr2,2048,host,port);
        ds.send(dp);

        dp = new DatagramPacket(arr2, 2048);
        ds.receive(dp);

        for (byte j : arr2) {
            System.out.println(j);
        }
    }
}
