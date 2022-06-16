package threadss;

import classes.MessagePacket;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.util.concurrent.atomic.AtomicReference;

public class Sendm extends Thread {
    private final AtomicReference<MessagePacket> packout;
    private final DatagramChannel dc;
    private final AtomicReference<SocketAddress> addr;

    public Sendm(AtomicReference<MessagePacket> packout, DatagramChannel dc, AtomicReference<SocketAddress> addr) {
        this.packout = packout;
        this.dc = dc;
        this.addr = addr;
    }

    @Override
    public void run() {
        try {
            synchronized (this) {
                this.wait();
            }
            //System.out.println(packout.get().getComm() + "*****");
            ByteArrayOutputStream baos = new ByteArrayOutputStream(4096);
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(packout.get());
            byte[] arr = baos.toByteArray();
            ByteBuffer buf = ByteBuffer.wrap(arr);
            dc.send(buf, addr.get());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
