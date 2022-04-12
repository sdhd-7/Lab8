package clie;

import java.io.IOException;
import java.net.InetAddress;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        InetAddress host = InetAddress.getLocalHost();
        int port = 1337;
        ClientConnection connect = new ClientConnection(new Scanner(System.in), host, port);
        connect.go();

    }
}
