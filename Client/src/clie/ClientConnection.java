/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clie;

import classes.MessagePacket;

import java.io.*;
import java.math.BigInteger;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;
/**
 *
 * @author adgjw
 */
public class ClientConnection {

    private final Scanner input;
    private final InetAddress host;

    private final DatagramSocket ds;
    private final int port;

    public ClientConnection(Scanner input, InetAddress host, int port) {
        this.host = host;
        this.input = input;
        this.port = port;
        try {
            this.ds = new DatagramSocket();
        } catch (SocketException e) {
            throw new RuntimeException(e);
        }
    }

    public int getPort() {
        return this.port;
    }

    public MessagePacket newsend(MessagePacket packet) throws IOException, ClassNotFoundException {

        ByteArrayOutputStream baos = new ByteArrayOutputStream(2048);
        ObjectOutputStream oos = new ObjectOutputStream(baos);

        oos.writeObject(packet);
        byte[] arr = baos.toByteArray(), ars = new byte[4096];

        DatagramPacket dps = new DatagramPacket(arr, arr.length, host, port);
        ds.send(dps);
        DatagramPacket dpr = new DatagramPacket(ars, ars.length);
        ds.receive(dpr);

        ByteArrayInputStream bis = new ByteArrayInputStream(ars);
        ObjectInputStream oin = new ObjectInputStream(bis);
        MessagePacket tmp = (MessagePacket) oin.readObject();
        return tmp;
    }


    public String send(MessagePacket packet) throws IOException, ClassNotFoundException {

        ByteArrayOutputStream baos = new ByteArrayOutputStream(2048);
        ObjectOutputStream oos = new ObjectOutputStream(baos);

        oos.writeObject(packet);
        byte[] arr = baos.toByteArray(), ars = new byte[4096];

        DatagramPacket dps = new DatagramPacket(arr, arr.length, host, port);
        ds.send(dps);
        DatagramPacket dpr = new DatagramPacket(ars, ars.length);
        ds.receive(dpr);

        ByteArrayInputStream bis = new ByteArrayInputStream(ars);
        ObjectInputStream oin = new ObjectInputStream(bis);
        MessagePacket tmp = (MessagePacket) oin.readObject();
        //System.out.println(tmp.getComm());
        return tmp.getComm();
    }


    public String SHA512(String in) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            byte[] messageDigest = md.digest(in.getBytes());
            BigInteger no = new BigInteger(1, messageDigest);
            return no.toString(16);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

    }
}

