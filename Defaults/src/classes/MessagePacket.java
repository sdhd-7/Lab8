package classes;

import java.io.Serializable;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class MessagePacket implements Serializable {
    private String comm;

    private int col;
    private String login;
    private String arg;
    private Dragon obj;

    private List<Dragon> dragons = Collections.synchronizedList(new LinkedList<>());
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

    public List<Dragon> getDragons() {
        return dragons;
    }

    public void setDragons(List<Dragon> dragons) {
        this.dragons = dragons;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public void setComm(String comm) {
        this.comm = comm;
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
