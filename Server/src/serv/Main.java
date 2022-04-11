package serv;

import com.google.gson.Gson;
import commands.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.*;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

public class Main {
    public static void main(String[] args) throws IOException{
        Init maker = new Init(args[0]);
        System.out.println(new ShowComm(maker).make());
        System.out.println(new AgeComm(maker).make("3"));
        //System.out.println(new ShowComm(maker).make());

        /*ByteArrayOutputStream baos = new ByteArrayOutputStream(2048);
        ObjectOutputStream oos = new ObjectOutputStream(baos);

        oos.writeObject(maker.getDragons().get(0));
        oos.flush();
        byte[] arr = baos.toByteArray();

        byte[] arr2 = new byte[10];
        int len = arr.length;
        int len2 = 10;

        DatagramChannel dc; ByteBuffer buf, buf2;
        int port = 1337;
        SocketAddress addr = new InetSocketAddress(port);
        dc = DatagramChannel.open();
        dc.bind(addr);

        buf = ByteBuffer.wrap(arr);
        buf2 = ByteBuffer.wrap(arr);
        addr = dc.receive(buf);
        for (int j = 0; j < len; j++) {
            System.out.println(arr[j]);
        }
        System.out.println(arr.length);
        buf.flip();
        dc.send(buf2, addr);

         */
    }
}
