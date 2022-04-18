package serv;

import classes.MessagePacket;
import commands.*;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
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

    public void go() throws IOException, InterruptedException {

        int i = 0;
        while (i < 1000) {
            i++;
            System.out.println(i);
            AtomicReference<SocketAddress> addr = new AtomicReference<>();
            AtomicReference<MessagePacket> tmp = new AtomicReference<>();
            AtomicReference<MessagePacket> packout = new AtomicReference<>();

            Runnable takem = () -> {

                try {
                    byte[] arr = new byte[4096];
                    ByteBuffer buf;
                    buf = ByteBuffer.wrap(arr);
                    System.out.println("popa");
                    SocketAddress sa = dc.receive(buf);
                    System.out.println(sa);
                    addr.set(sa);
                    System.out.println(addr.get());
                    ByteArrayInputStream bis = new ByteArrayInputStream(arr);
                    ObjectInputStream oin = new ObjectInputStream(bis);
                    tmp.set((MessagePacket) oin.readObject());
                    System.out.println(tmp.get().getComm());
                } catch (IOException | ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }

                Runnable makem = () -> {
                    if (tmp.get().getComm().equalsIgnoreCase("newlogin") ||
                            tmp.get().getComm().equalsIgnoreCase("login")) {
                        packout.set(new MessagePacket(comm.get(tmp.get().getComm()).make(tmp.get().getLogin(), tmp.get().getArg()), ""));
                    } else if (tmp.get().getComm().equalsIgnoreCase("remove_by_id") ||
                            tmp.get().getComm().equalsIgnoreCase("remove_by_type")) {
                        packout.set(new MessagePacket(comm.get(tmp.get().getComm()).make(tmp.get().getArg(), tmp.get().getLogin()), ""));
                    } else if (tmp.get().getComm().equalsIgnoreCase("update")) {
                        packout.set(new MessagePacket(comm.get(tmp.get().getComm()).make(tmp.get().getObj(), tmp.get().getLogin()), ""));
                    } else if (tmp.get().getObj() != null) {
                        packout.set(new MessagePacket(comm.get(tmp.get().getComm()).make(tmp.get().getObj()), ""));
                    } else if (tmp.get().getArg() != null) {
                        packout.set(new MessagePacket(comm.get(tmp.get().getComm()).make(tmp.get().getArg()), ""));
                    } else {
                        packout.set(new MessagePacket(comm.get(tmp.get().getComm()).make(), ""));
                    }
                    Runnable sendm = () -> {
                        while (packout == null) {
                            try {
                                wait();
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        }
                        byte[] arr;
                        ByteBuffer buf;
                        ByteArrayOutputStream baos = new ByteArrayOutputStream(4096);
                        ObjectOutputStream oos = null;
                        try {
                            oos = new ObjectOutputStream(baos);
                            oos.writeObject(packout.get());
                            arr = baos.toByteArray();
                            buf = ByteBuffer.wrap(arr);
                            dc.send(buf, addr.get());

                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    };
                    Thread kek2 = new Thread(sendm);
                    kek2.start();
                };
                service.submit(makem);
            };


            Thread kek = new Thread(takem);

            System.out.println("lol");
            kek.start();
            System.out.println(kek.getName());
            kek.join();
            System.out.println("ppp");

        }
    }
}
