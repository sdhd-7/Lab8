package commands;

import serv.Init;

public class RemoveByTypeComm extends AbstractComm {
    public RemoveByTypeComm(Init m) {
        super(m);
    }

    @Override
    public synchronized String make(String s, String login) {
        getMaker().getHistory_list().add("remove by type");
        int tmp = getMaker().getDragons().size();
        getMaker().getDragons().removeIf(p -> s.equals(p.getType().toString()) && login.equalsIgnoreCase(p.getLogin()));
        getMaker().save();
        if (tmp == getMaker().getDragons().size())
            return "В коллекции нет драконов с таким типом или тип был введен неверно.";
        else
            return "Было удалено " + (tmp - getMaker().getDragons().size()) + " элементов.";
    }
}
