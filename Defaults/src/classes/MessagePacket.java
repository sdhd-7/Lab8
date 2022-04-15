package classes;

import java.io.Serializable;

public class MessagePacket implements Serializable {
    private String comm;

    private String login;
    private String arg;
    private Dragon obj;
    private boolean use = false;

    public MessagePacket() {
        use = false;
    }

    public MessagePacket(String comm, String lg) {
        this.comm = comm;
        this.login = lg;
        use = true;
    }

    public MessagePacket(String comm, String arg, String lg) {
        this.comm = comm;
        this.arg = arg;
        this.login = lg;
        use = true;
    }

    public MessagePacket(String comm, Dragon obj, String lg) {
        this.comm = comm;
        this.obj = obj;
        this.login = lg;
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

    public String getLogin() {
        return login;
    }

    public boolean isUse() {
        return use;
    }
}
