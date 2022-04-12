package commands;

import serv.Init;

import java.util.Collections;

public class ShowComm extends AbstractComm {
    public ShowComm(Init maker) {
        super(maker);
    }

    @Override
    public synchronized String make() {
        getMaker().getHistory_list().add("show");
        StringBuilder ans = new StringBuilder();
        ans.append("В коллекции ").append(getMaker().getDragons().size()).append(" элементов:").append('\n');
        Collections.sort(getMaker().getDragons());
        getMaker().getDragons().forEach(tmp -> ans.append(getMaker().getGson().toJson(tmp)).append('\n'));
        return ans.toString();
    }
}
