package threadss;

import classes.MessagePacket;
import commands.AbstractComm;

import java.util.Hashtable;
import java.util.concurrent.atomic.AtomicReference;

public class Makem extends Thread {
    private final AtomicReference<MessagePacket> tmp, packout;
    private final Hashtable<String, AbstractComm> comm;
    private final Sendm send;

    public Makem(AtomicReference<MessagePacket> tmp, AtomicReference<MessagePacket> packout,
                 Hashtable<String, AbstractComm> comm, Sendm send) {
        this.tmp = tmp;
        this.packout = packout;
        this.comm = comm;
        this.send = send;
        //start();
    }

    @Override
    public void run() {
        //System.out.println("ready");
        synchronized (this) {
            try {
                //System.out.println("pizda");
                this.wait();
                //System.out.println("pizda2");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        //System.out.println("bebra");
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
        //System.out.println("kringe");
        synchronized (send) {
            send.notify();
        }
    }
}
