/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package form;

import clie.ClientConnection;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * @author adgjw
 */
public class ThreadG extends Thread {
    public ThreadG() {
        super();
    }

    @Override
    public void run() {
        InetAddress host = null;
        try {
            host = InetAddress.getLocalHost();
            //host = InetAddress.getByName("192.168.31.14");

        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
        int port = 1338;
        ClientConnection connect = new ClientConnection(new Scanner(System.in), host, port);
        Login lg = new Login(connect);
        lg.pack();
        lg.setVisible(true);
    }
}
