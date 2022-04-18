package commands;

import classes.Dragon;
import serv.Init;

public class UpdateComm extends AbstractComm {
    public UpdateComm(Init m) {
        super(m);
    }

    @Override
    public synchronized String make(Dragon arg, String login) {
        try {
            getMaker().getHistory_list().add("update by id");
            Dragon tmp = getMaker().getDragons().stream().filter(x -> x.getId() == arg.getId() &&
                    x.getLogin().equalsIgnoreCase(login)).findFirst().get();
            getMaker().getDragons().remove(tmp);
            getMaker().getDragons().add(arg);
            getMaker().save();
            return "Элемент с id " + arg.getId() + " успешно обновлен.";
        } catch (Exception e) {
            return "В коллекции нет элемента с id " + arg.getId();
        }
    }
}
