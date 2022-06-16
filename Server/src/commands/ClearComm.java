package commands;

import serv.Init;

public class ClearComm extends AbstractComm {
    public ClearComm() {
        super();
    }

    @Override
    public synchronized String make() {
        Init.getInstance().getHistory_list().add("clear");
        Init.getInstance().getDragons().clear();
        Init.getInstance().save();
        return "Коллекция успешно очищена";
    }
}
