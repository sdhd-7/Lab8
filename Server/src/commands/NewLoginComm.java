package commands;

import managers.DBManager;

import java.sql.SQLException;

public class NewLoginComm extends AbstractComm {
    public NewLoginComm() {
        super();
    }

    @Override
    public synchronized String make(String log, String pass, int col) {
        try {
            DBManager.getInstance().getConnection().createStatement().execute("insert into users values (" + "'" + log + "' ,'" + pass + "'," + col + ")");
        } catch (SQLException e) {
            return "bad";

        }
        return "Успешное добавление пользователя и авторизация";
    }
}
