package commands;

import serv.Init;

import java.util.Collections;

public class ShowComm extends AbstractComm {
    public ShowComm() {
        super();
    }

    @Override
    public synchronized String make() {
        Init.getInstance().getHistory_list().add("show");
        StringBuilder ans = new StringBuilder();
        ans.append("В коллекции ").append(Init.getInstance().getDragons().size()).append(" элементов:").append('\n');
        Collections.sort(Init.getInstance().getDragons());
        Init.getInstance().getDragons().forEach(tmp -> ans.append(Init.getInstance().getGson().toJson(tmp)).append('\n'));
        return ans.toString();
    }
}
