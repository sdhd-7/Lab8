package serv;

import classes.Coordinates;
import classes.Dragon;
import classes.DragonCharacter;
import classes.DragonType;
import com.google.gson.Gson;
import managers.DBManager;

import java.io.File;
import java.lang.reflect.Type;
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
    private File file;
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

    public String save() {
        System.out.println("lol");
        try (Connection connect = DBManager.getInstance().getConnection();
             Statement req = connect.createStatement()) {
            connect.setAutoCommit(false);
            req.addBatch("DELETE from dragon");
            for (Dragon tmp : dragons) {
                System.out.println(tmp.getId());
                req.addBatch("insert into dragon VALUES (" + tmp.getId() + ",'" + tmp.getName() + "'," +
                        tmp.getCoordinates().getX() + ',' + tmp.getCoordinates().getY() + ",'" +
                        gson.toJson(tmp.getCreationDate()) + "'," + tmp.getAge() + ',' + tmp.isSpeaking() + ",'" +
                        gson.toJson(tmp.getType()) + "','" + gson.toJson(tmp.getCharacter()) + "','" + tmp.getLogin() + "')");
            }
            req.executeBatch();
            connect.commit();
            load();
            return "Коллекция успешно сохранена.";
        } catch (SQLException e) {
            e.printStackTrace();
            return "не удалось сохранить коллекцию.";
        }
    }

    public String load() {
        try {
            ResultSet tmp = DBManager.getInstance().getConnection().createStatement().executeQuery("SELECT * FROM dragon");
            dragons.clear();
            while (tmp.next()) {
                Dragon kek = new Dragon();
                long x, y;
                kek.setId(tmp.getLong("id"));
                kek.setCharacter(gson.fromJson(tmp.getString("character"), (Type) DragonCharacter.class));
                kek.setType(gson.fromJson(tmp.getString("type"), (Type) DragonType.class));
                x = tmp.getLong("x");
                y = tmp.getLong("y");
                kek.setCoordinates(new Coordinates(x, y));
                kek.setCreationDate(gson.fromJson(tmp.getString("creationdate"), LocalDateTime.class));
                kek.setLogin(tmp.getString("login"));
                kek.setAge(tmp.getInt("age"));
                kek.setSpeaking(tmp.getBoolean("speaking"));
                kek.setName(tmp.getString("name"));
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
