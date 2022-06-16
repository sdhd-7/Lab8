package commands;

import serv.Init;

public class RemoveFirstComm extends AbstractComm {
    public RemoveFirstComm() {
        super();
    }

    @Override
    public synchronized String make() {
        Init.getInstance().getHistory_list().add("remove first");
        if (Init.getInstance().getDragons().size() == 0)
            return "Коллекция пуста";
        else {
            Init.getInstance().getDragons().remove(0);
            Init.getInstance().save();
            return "Первый элемент успешно удален";
        }
    }
}
