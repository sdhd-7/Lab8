package commands;

import serv.Init;

public class InfoComm extends AbstractComm {
    public InfoComm() {
        super();
    }

    @Override
    public synchronized String make() {
        Init.getInstance().getHistory_list().add("info");
        return Init.getInstance().toString();
    }
}
