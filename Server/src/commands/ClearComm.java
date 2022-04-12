package commands;

import serv.Init;

public class ClearComm extends AbstractComm {
    public ClearComm(Init maker) {
        super(maker);
    }

    @Override
    public synchronized String make() {
        getMaker().getHistory_list().add("clear");
        getMaker().getDragons().clear();
        return "Коллекция успешно очищена";
    }
}
