package classes;

import java.io.Serializable;

public class MessagePacket implements Serializable {
    private String comm;
    private String arg;
    private Dragon obj;
    private boolean use = false;

    public MessagePacket() {
        use = false;
    }

    public MessagePacket(String comm) {
        this.comm = comm;
        use = true;
    }

    public MessagePacket(String comm, String arg) {
        this.comm = comm;
        this.arg = arg;
        use = true;
    }

    public MessagePacket(String comm, Dragon obj) {
        this.comm = comm;
        this.obj = obj;
        use = true;
    }

    public String getComm() {
        return comm;
    }

    public String getArg() {
        return arg;
    }

    public Dragon getObj() {
        return obj;
    }

    public boolean isUse() {
        return use;
    }
}
