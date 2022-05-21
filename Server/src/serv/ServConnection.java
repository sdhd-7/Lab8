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

    private final DatagramChannel dc;

    public ServConnection(int port, Init maker) throws IOException {

        dc = DatagramChannel.open();
        dc.bind(new InetSocketAddress(port));
        comm.put("add", new AddComm(maker));
        comm.put("add_if_max", new AddIfMaxComm(maker));
        comm.put("age", new AgeComm(maker));
        comm.put("clear", new ClearComm(maker));
        comm.put("filter_by_character", new FilterByCharacterComm(maker));
        comm.put("help", new HelpComm(maker));
        comm.put("history", new HistoryComm(maker));
        comm.put("info", new InfoComm(maker));
        comm.put("remove_by_id", new RemoveByIdComm(maker));
        comm.put("remove_by_type", new RemoveByTypeComm(maker));
        comm.put("remove_first", new RemoveFirstComm(maker));
        comm.put("show", new ShowComm(maker));
        comm.put("update", new UpdateComm(maker));
        comm.put("login", new LoginComm(maker));
        comm.put("newlogin", new NewLoginComm(maker));


    }

    public void go() throws InterruptedException {
        do {
            //System.out.println(i);
            AtomicReference<SocketAddress> addr = new AtomicReference<>();
            AtomicReference<MessagePacket> tmp = new AtomicReference<>();
            AtomicReference<MessagePacket> packout = new AtomicReference<>();

            Sendm send = new Sendm(packout, dc, addr);
            Makem make = new Makem(tmp, packout, comm, send);
            Takem take = new Takem(tmp, dc, addr, make);

            take.start();
            service.submit(make);
            send.start();
            take.join();
        } while (true);
    }
}