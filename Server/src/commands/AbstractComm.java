package commands;

import programm.defaults.Dragon;
import serv.Init;

public abstract class AbstractComm {
    private final Init maker;

    public AbstractComm(Init maker) {
        this.maker = maker;
    }

    public synchronized String make() {
        return "default";
    }

    public synchronized String make(String arg) {
        return this.make();
    }

    public synchronized String make(Dragon arg) {
        return this.make();
    }

    public Init getMaker() {
        return maker;
    }
}
