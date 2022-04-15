package commands;

import classes.Dragon;
import serv.Init;

import java.util.Collections;

public class AddIfMaxComm extends AbstractComm {
    public AddIfMaxComm(Init m) {
        super(m);
    }

    @Override
    public synchronized String make(Dragon mainCompetitor) {
        getMaker().getHistory_list().add("add if max");
        if (getMaker().getDragons().size() != 0) {
            Dragon competitor = Collections.max(getMaker().getDragons());
            if (competitor.compareTo(mainCompetitor) < 0) {
                getMaker().getDragons().add(mainCompetitor);
                return "Элемент успешно добавлен.";
            } else return "Не удалось добавить элемент.";
        } else return "Элемент не с чем сравнивать. Коллекция пуста.";
    }
}
