package commands;

import classes.Dragon;
import managers.DBManager;
import serv.Init;

import java.sql.SQLException;

public class AddComm extends AbstractComm {
    public AddComm(Init maker) {
        super(maker);
    }

    @Override
    public synchronized String make(Dragon tmp) {
        getMaker().getHistory_list().add("add");
        tmp.setId((long) (Math.random() * 543323));
        try {
            DBManager.getInstance().getConnection().createStatement().execute("" +
                    "insert into dragon VALUES (" + tmp.getId() + ",'" + tmp.getName() + "'," +
                    tmp.getCoordinates().getX() + ',' + tmp.getCoordinates().getY() + ",'" +
                    getMaker().getGson().toJson(tmp.getCreationDate()) + "'," + tmp.getAge() + ',' + tmp.isSpeaking() + ",'" +
                    getMaker().getGson().toJson(tmp.getType()) + "','" + getMaker().getGson().toJson(tmp.getCharacter())
                    + "','" + tmp.getLogin() + "')");
        } catch (SQLException e) {
            //System.out.println(e.getMessage());
            return "Не удалось добавить элемент.";
        }
        getMaker().getDragons().add(tmp);
        getMaker().save();
        return "Элемент успешно добавлен.";
    }
}
