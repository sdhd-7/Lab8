package managers;

import classes.Dragon;

import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public final class DBManager {
    private static volatile DBManager instance;
    private String url;
    private String user;
    private String password;

    public Connection getConnection;

    {
        try (InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("db.properties")) {
            Properties prop = System.getProperties();
            prop.load(inputStream);
            url = prop.getProperty("url_address");
            user = prop.getProperty("user");
            password = prop.getProperty("password");
            System.out.println("База данных сконфигурирована с db.properties.");
            Tunnel tunnel = new Tunnel("helios.cs.ifmo.ru", prop.getProperty("user"), "DYgG%9918",
                    2222, "pg", 5432, 5432);
            System.out.println(System.getProperty("os.name"));
            if ("Windows 10".equals(System.getProperty("os.name")))
                tunnel.connect();
        } catch (IOException | NullPointerException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    private DBManager() throws SQLException {
        getConnection = DriverManager.getConnection(url, user, password);
        try (Connection testConnection = DriverManager.getConnection(url, user, password);
             ResultSet testRequest = testConnection.createStatement().executeQuery("SELECT version()")) {
            System.out.println("Идёт установка связи с БД.");
            while (testRequest.next())
                System.out.println("Связь с БД установлена." + " Версия: " + testRequest.getString(1));
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public static DBManager getInstance() throws SQLException {
        DBManager instance2 = instance;
        if (instance2 == null) {
            synchronized (DBManager.class) {
                instance2 = instance;
                if (instance2 == null) instance = new DBManager();
            }
        }
        return instance;
    }

    public void addDB(Dragon tmp) throws SQLException {
        ResultSet temp = DBManager.getInstance().getConnection().createStatement().executeQuery("SELECT nextval('studs.serial')");
        temp.next();
        long x = temp.getLong("nextval");
        //System.out.println(x);
        tmp.setId(x);
        ResultSet tmp2 = DBManager.getInstance().getConnection().createStatement().executeQuery("SELECT * FROM studs.users where login = '" + tmp.getLogin() + "'");
        tmp2.next();
        //return String.valueOf(tmp.getInt("color"));
        tmp.setCol(new Color(tmp2.getInt("color")));
        DBManager.getInstance().getConnection().createStatement().execute("" +
                "insert into studs.dragons VALUES (" + tmp.getId() + ",'" + tmp.getName() + "'," +
                tmp.getCoordinates().getX() + ',' + tmp.getCoordinates().getY() + ",'" +
                tmp.getCreationDate().toString() + "'," + tmp.getAge() + ',' + tmp.isSpeaking() + ",'" +
                tmp.getType().toString() + "','" + tmp.getCharacter().toString()
                + "','" + tmp.getLogin() + "'," + tmp.getCol().getRGB() + ")");
    }

    public Connection getConnection() throws SQLException {
        if (getConnection.isClosed()) {
            getConnection = DriverManager.getConnection(url, user, password);
        }
        return getConnection;
    }
}
