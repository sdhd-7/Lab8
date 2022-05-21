package threadss;

import classes.MessagePacket;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.util.concurrent.atomic.AtomicReference;

public class Takem extends Thread {
    private final AtomicReference<MessagePacket> tmp;
    private final DatagramChannel dc;
    private final AtomicReference<SocketAddress> addr;
    private final Makem make;

    public Takem(AtomicReference<MessagePacket> tmp, DatagramChannel dc, AtomicReference<SocketAddress> addr, Makem make) {
        this.tmp = tmp;
        this.dc = dc;
        this.addr = addr;
        this.make = make;
        //start();
    }

    @Override
    public void run() {
        try {
            byte[] arr = new byte[4096];
            ByteBuffer buf;
            buf = ByteBuffer.wrap(arr);
            //System.out.println("popa");
            SocketAddress sa = dc.receive(buf);
            System.out.println(sa);
            addr.set(sa);
            //System.out.println(addr.get());
            ByteArrayInputStream bis = new ByteArrayInputStream(arr);
            ObjectInputStream oin = new ObjectInputStream(bis);
            tmp.set((MessagePacket) oin.readObject());
            //System.out.println(tmp.get().getComm());
            synchronized (make) {
                make.notify();
            }
            //System.out.println("lol");
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
