package serv;

import classes.Coordinates;
import classes.Dragon;
import classes.DragonCharacter;
import classes.DragonType;
import com.google.gson.Gson;
import managers.DBManager;

import java.awt.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public final class Init {
    private final List<Dragon> dragons = Collections.synchronizedList(new LinkedList<>());
    private final Gson gson = new Gson();
    private final List<String> history_list = Collections.synchronizedList(new LinkedList<>());
    private final Date initdate;

    private static volatile Init instance;

    public Init() {
        initdate = new Date();
        System.out.println(load());
    }

    public static Init getInstance() {

        Init instance2 = instance;
        if (instance2 == null) {
            synchronized (Init.class) {
                instance2 = instance;
                if (instance2 == null) instance = instance2 = new Init();
            }
        }
        return instance;
    }

    public void save() {
        //System.out.println("lol");
        try (Connection connect = DBManager.getInstance().getConnection();
             Statement req = connect.createStatement()) {
            connect.setAutoCommit(false);
            req.addBatch("DELETE from studs.dragons");
            for (Dragon tmp : dragons) {
                //System.out.println(tmp.getId());
                req.addBatch("insert into studs.dragons VALUES (" + tmp.getId() + ",'" + tmp.getName() + "'," +
                        tmp.getCoordinates().getX() + ',' + tmp.getCoordinates().getY() + ",'" +
                        tmp.getCreationDate().toString() + "'," + tmp.getAge() + ',' + tmp.isSpeaking() + ",'" +
                        tmp.getType().toString() + "','" + tmp.getCharacter().toString() + "','" + tmp.getLogin() +
                        "'," + tmp.getCol().getRGB() + ")");
            }
            req.executeBatch();
            connect.commit();
            load();
            System.out.println("Коллекция успешно сохранена.");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("не удалось сохранить коллекцию.");
        }
    }

    public String load() {
        try {
            System.out.println("kek");
            ResultSet tmp = DBManager.getInstance().getConnection().createStatement().executeQuery("SELECT * FROM studs.dragons");
            dragons.clear();
            while (tmp.next()) {
                Dragon kek = new Dragon();
                long x, y;
                kek.setId(tmp.getLong("id"));
                System.out.println(tmp.getString("character") + " " + tmp.getString("character").getClass());
                kek.setCharacter(DragonCharacter.valueOf(tmp.getString("character")));
                kek.setType(DragonType.valueOf(tmp.getString("type")));
                x = tmp.getLong("x");
                y = tmp.getLong("y");
                kek.setCoordinates(new Coordinates(x, y));
                kek.setCreationDate(LocalDateTime.parse(tmp.getString("creationdate")));
                kek.setLogin(tmp.getString("login"));
                kek.setAge(tmp.getInt("age"));
                kek.setSpeaking(tmp.getBoolean("speaking"));
                kek.setName(tmp.getString("name"));
                kek.setCol(new Color(tmp.getInt("color")));
                dragons.add(kek);
            }
            return "Загружено " + dragons.size() + " новых элементов.";
        } catch (SQLException e) {
            e.printStackTrace();
            return "Не удалось загрузить элементы";
        }
    }

    public List<Dragon> getDragons() {
        return dragons;
    }

    public List<String> getHistory_list() {
        return history_list;
    }

    public Gson getGson() {
        return gson;
    }

    @Override
    public String toString() {
        return "Тип коллекции: " + dragons.getClass() +
                "\nТип элементов: " + Dragon.class +
                "\nДата инициализации: " + initdate +
                "\nКоличество элементов: " + dragons.size();
    }
}
