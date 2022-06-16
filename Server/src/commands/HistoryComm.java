package commands;

import serv.Init;

public class HistoryComm extends AbstractComm {

    public HistoryComm() {
        super();
    }

    @Override
    public synchronized String make() {
        Init.getInstance().getHistory_list().add("history");
        while (Init.getInstance().getHistory_list().size() > 15) {
            Init.getInstance().getHistory_list().remove(15);
        }
        StringBuilder ans = new StringBuilder();
        Init.getInstance().getHistory_list().forEach(tmp -> ans.append("-> ").append(tmp).append('\n'));
        return ans.toString();

    }
}
