package commands;

import managers.DBManager;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ColorComm extends AbstractComm {
    public ColorComm() {
        super();
    }

    @Override
    public synchronized String make(String login) {
        System.out.println(login);
        try {
            ResultSet tmp = DBManager.getInstance().getConnection().createStatement().executeQuery("SELECT * FROM studs.users where login = '" + login + "'");
            tmp.next();
            System.out.println(tmp.getInt("color") + " " + login);
            return String.valueOf(tmp.getInt("color"));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
