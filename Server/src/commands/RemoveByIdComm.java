package commands;

import serv.Init;

public class RemoveByIdComm extends AbstractComm {
    public RemoveByIdComm() {
        super();
    }

    @Override
    public synchronized String make(String s, String login) {
        Init.getInstance().getHistory_list().add("remove by id");
        long id;
        try {
            id = Long.parseLong(s);
        } catch (Exception ex) {
            return "Неверный тип аргумента";
        }
        int tmp = Init.getInstance().getDragons().size();
        Init.getInstance().getDragons().removeIf(p -> p.getId() == id && p.getLogin().equalsIgnoreCase(login));
        Init.getInstance().save();
        if (tmp == Init.getInstance().getDragons().size())
            return "В коллекции нет элемента с id " + id + " или вы не имеете к нему доступ.";
        else
            return "Элемент успешно удален";
    }
}
