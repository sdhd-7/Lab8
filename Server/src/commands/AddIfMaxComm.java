package commands;

import classes.Dragon;
import managers.DBManager;
import serv.Init;

import java.sql.SQLException;
import java.util.Collections;

public class AddIfMaxComm extends AbstractComm {
    public AddIfMaxComm() {
        super();
    }

    @Override
    public synchronized String make(Dragon mainCompetitor) {
        Init.getInstance().getHistory_list().add("add if max");
        if (Init.getInstance().getDragons().size() != 0) {
            Dragon competitor = Collections.max(Init.getInstance().getDragons());
            if (competitor.compareTo(mainCompetitor) < 0) {
                try {
                    DBManager.getInstance().addDB(mainCompetitor);
                } catch (SQLException e) {
                    return "Не удалось добавить элемент.";
                }
                Init.getInstance().getDragons().add(mainCompetitor);
                Init.getInstance().save();
                return "Элемент успешно добавлен.";
            } else return "Не удалось добавить элемент.";
        } else return "Элемент не с чем сравнивать. Коллекция пуста.";
    }
}
