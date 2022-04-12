package commands;

import serv.Init;

public class InfoComm extends AbstractComm {
    public InfoComm(Init maker) {
        super(maker);
    }

    @Override
    public synchronized String make() {
        getMaker().getHistory_list().add("info");
        return getMaker().toString();
    }
}
