package commands;

import serv.Init;

import java.util.LinkedList;

public class HistoryComm extends AbstractComm {

    public HistoryComm(Init maker) {
        super(maker);
    }

    @Override
    public synchronized String make() {
        getMaker().getHistory_list().add("history");
        LinkedList<String> history = getMaker().getHistory_list();
        while (history.size() > 15) {
            history.removeLast();
        }
        StringBuilder ans = new StringBuilder();
        history.forEach(tmp -> ans.append("-> ").append(tmp).append('\n'));
        return ans.toString();

    }
}
