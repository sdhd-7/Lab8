package clie;

import gui.go;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Runnable task = () -> {
            InetAddress host = null;
            try {
                host = InetAddress.getLocalHost();
            } catch (UnknownHostException e) {
                throw new RuntimeException(e);
            }
            int port = 1337;
            ClientConnection connect = new ClientConnection(new Scanner(System.in), host, port);
            try {
                connect.go();
            } catch (IOException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        };
        Runnable guis = () -> {
            InetAddress host = null;
            try {
                host = InetAddress.getLocalHost();
            } catch (UnknownHostException e) {
                throw new RuntimeException(e);
            }
            int port = 1337;
            ClientConnection connect = new ClientConnection(new Scanner(System.in), host, port);
            go dialog = new go(connect);
            dialog.pack();
            dialog.setVisible(true);
            //System.exit(0);
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(guis);
        //t1.start();
        t2.start();


    }
}
