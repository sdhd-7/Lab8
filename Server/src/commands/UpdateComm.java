package commands;

import classes.Dragon;
import serv.Init;

public class UpdateComm extends AbstractComm {
    public UpdateComm() {
        super();
    }

    @Override
    public synchronized String make(Dragon arg, String login) {
        try {
            System.out.println(arg.getId() + "***" + login);
            Init.getInstance().getHistory_list().add("update by id");
            Dragon tmp = Init.getInstance().getDragons().stream().filter(x -> x.getId() == arg.getId() &&
                    x.getLogin().equalsIgnoreCase(login)).findFirst().get();
            Init.getInstance().getDragons().remove(tmp);
            Init.getInstance().getDragons().add(arg);
            Init.getInstance().save();
            return "Элемент с id успешно обновлен.";
        } catch (Exception e) {
            return "В коллекции нет элемента с id";
        }
    }
}
