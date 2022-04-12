package commands;

import serv.Init;

public class HistoryComm extends AbstractComm {

    public HistoryComm(Init maker) {
        super(maker);
    }

    @Override
    public synchronized String make() {
        getMaker().getHistory_list().add("history");
        while (getMaker().getHistory_list().size() > 15) {
            getMaker().getHistory_list().remove(15);
        }
        StringBuilder ans = new StringBuilder();
        getMaker().getHistory_list().forEach(tmp -> ans.append("-> ").append(tmp).append('\n'));
        return ans.toString();

    }
}
