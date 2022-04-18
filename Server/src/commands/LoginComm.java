package commands;

import managers.DBManager;
import serv.Init;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginComm extends AbstractComm {
    public LoginComm(Init m) {
        super(m);
    }

    @Override
    public synchronized String make(String log, String pass) {
        try {
            ResultSet tmp = DBManager.getInstance().getConnection().createStatement().executeQuery("SELECT * FROM users where login=" + "'" + log + "'");
            if (!tmp.next() || !tmp.getString("password").equals(pass))
                return "Неверный логин и/или пароль.";
            return "Успешная авторизация";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
