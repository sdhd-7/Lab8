package commands;

import classes.Dragon;
import managers.DBManager;
import serv.Init;

import java.sql.SQLException;

public class AddComm extends AbstractComm {
    public AddComm() {
        super();
    }

    @Override
    public synchronized String make(Dragon tmp) {
        Init.getInstance().getHistory_list().add("add");

        try {
            DBManager.getInstance().addDB(tmp);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return "Не удалось добавить элемент.";
        }
        Init.getInstance().getDragons().add(tmp);
        Init.getInstance().save();
        return "Элемент успешно добавлен.";
    }
}
