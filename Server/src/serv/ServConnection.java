package serv;

import classes.MessagePacket;
import commands.*;
import threadss.Makem;
import threadss.Sendm;
import threadss.Takem;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.channels.DatagramChannel;
import java.util.Hashtable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicReference;

public class ServConnection {

    private static final ExecutorService service = Executors.newCachedThreadPool();
    private final Hashtable<String, AbstractComm> comm = new Hashtable<>();

    public static volatile int count = 0;
    private final DatagramChannel dc;

    public ServConnection(int port) throws IOException {
        Init.getInstance();
        dc = DatagramChannel.open();
        dc.bind(new InetSocketAddress(port));
        comm.put("add", new AddComm());
        comm.put("add_if_max", new AddIfMaxComm());
        comm.put("count_by_age", new AgeComm());
        comm.put("clear", new ClearComm());
        comm.put("filter_by_character", new FilterByCharacterComm());
        comm.put("help", new HelpComm());
        comm.put("history", new HistoryComm());
        comm.put("info", new InfoComm());
        comm.put("remove_by_id", new RemoveByIdComm());
        comm.put("remove_by_type", new RemoveByTypeComm());
        comm.put("remove_first", new RemoveFirstComm());
        comm.put("show", new ShowComm());
        comm.put("update", new UpdateComm());
        comm.put("login", new LoginComm());
        comm.put("newlogin", new NewLoginComm());
        comm.put("data", new ListD());


    }

    public void go() throws InterruptedException {
        while (true) {
            if (count < 15) {
                //System.out.println(i);
                AtomicReference<SocketAddress> addr = new AtomicReference<>();
                AtomicReference<MessagePacket> tmp = new AtomicReference<>();
                AtomicReference<MessagePacket> packout = new AtomicReference<>();

                count++;
                Sendm send = new Sendm(packout, dc, addr);
                Makem make = new Makem(tmp, packout, comm, send);
                Takem take = new Takem(tmp, dc, addr, make);
                //System.out.println(count + "*");
                take.start();
                service.submit(make);
                send.start();
                //take.join();
                //System.out.println(count + " % ");
            }
            //System.out.println("11! " + count);
        }
    }
}