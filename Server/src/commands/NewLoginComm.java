package commands;

import managers.DBManager;
import serv.Init;

import java.sql.ResultSet;
import java.sql.SQLException;

public class NewLoginComm extends AbstractComm {
    public NewLoginComm(Init m) {
        super(m);
    }

    @Override
    public synchronized String make(String log, String pass) {
        try {
            ResultSet tmp = DBManager.getInstance().getConnection().createStatement().executeQuery("SELECT * FROM users where login=" + "'" + log + "'");
            if (tmp.next())
                return "Пользователь с данным логином уже существует.";
            else {
                DBManager.getInstance().getConnection().createStatement().execute("insert into users values (" + "'" + log + "' ,'" + pass + "')");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return "Успешное добавление пользователя и авторизация";
    }
}
