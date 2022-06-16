package commands;

import classes.Dragon;
import serv.Init;

import java.util.List;

public abstract class AbstractComm {


    public AbstractComm() {
    }

    public synchronized String make() {
        return "default";
    }

    public synchronized String make(String arg) {
        return this.make();
    }

    public synchronized String make(String log, String pass) {
        return this.make();
    }

    public synchronized String make(String log, String pass, int col) {
        return this.make();
    }

    public synchronized String make(Dragon arg) {
        return this.make();
    }

    public synchronized String make(Dragon arg, String login) {
        return this.make();
    }


    public synchronized List<Dragon> maker() {
        return Init.getInstance().getDragons();
    }


}
