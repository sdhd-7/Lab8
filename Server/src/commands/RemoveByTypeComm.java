package commands;

import serv.Init;

public class RemoveByTypeComm extends AbstractComm {
    public RemoveByTypeComm() {
        super();
    }

    @Override
    public synchronized String make(String s, String login) {
        Init.getInstance().getHistory_list().add("remove by type");
        int tmp = Init.getInstance().getDragons().size();
        Init.getInstance().getDragons().removeIf(p -> s.equals(p.getType().toString()) && login.equalsIgnoreCase(p.getLogin()));
        Init.getInstance().save();
        if (tmp == Init.getInstance().getDragons().size())
            return "В коллекции нет драконов с таким типом или тип был введен неверно.";
        else
            return "" + (tmp - Init.getInstance().getDragons().size());
    }
}
