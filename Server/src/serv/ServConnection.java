package serv;

import commands.*;
import programm.helper.MessagePacket;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.util.Hashtable;
import java.util.Scanner;

public class ServConnection {
    private Init maker;
    private SocketAddress addr;
    private int port;
    private Hashtable<String, AbstractComm> comm = new Hashtable<>();


    public ServConnection(int port, Init maker) {
        this.port = port;
        this.maker = maker;
        this.addr = new InetSocketAddress(port);

        comm.put("add", new AddComm(maker));
        comm.put("add_if_max", new AddIfMaxComm(maker));
        comm.put("age", new AgeComm(maker));
        comm.put("clear", new ClearComm(maker));
        comm.put("filter_by_character", new FilterByCharacterComm(maker));
        comm.put("help", new HelpComm(maker));
        comm.put("history", new HistoryComm(maker));
        comm.put("info", new InfoComm(maker));
        comm.put("remove_by_id", new RemoveByIdComm(maker));
        comm.put("remove_by_type", new RemoveByIdComm(maker));
        comm.put("remove_first", new RemoveFirstComm(maker));
        comm.put("show", new ShowComm(maker));
        comm.put("update", new UpdateComm(maker));


    }

    public void go() throws IOException, ClassNotFoundException {
        Scanner sc = new Scanner(System.in);
        DatagramChannel dc;
        dc = DatagramChannel.open();
        dc.bind(addr);
        while (true) {
            byte arr[] = new byte[2048];

            int len = arr.length;

            ByteBuffer buf;
            buf = ByteBuffer.wrap(arr);
            addr = dc.receive(buf);

            ByteArrayInputStream bis = new ByteArrayInputStream(arr);
            ObjectInputStream oin = new ObjectInputStream(bis);
            MessagePacket tmp = (MessagePacket) oin.readObject();


            MessagePacket packout;
            if (tmp.getObj() != null) {
                packout = new MessagePacket(comm.get(tmp.getComm()).make(tmp.getObj()));
            } else if (tmp.getArg() != null) {
                packout = new MessagePacket(comm.get(tmp.getComm()).make(tmp.getArg()));
            } else {
                packout = new MessagePacket(comm.get(tmp.getComm()).make());
            }

            ByteArrayOutputStream baos = new ByteArrayOutputStream(4096);
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(packout);
            arr = baos.toByteArray();
            buf = ByteBuffer.wrap(arr);
            dc.send(buf, addr);
        }
    }
}
