package commands;

import serv.Init;

public class RemoveByIdComm extends AbstractComm {
    public RemoveByIdComm(Init m) {
        super(m);
    }

    @Override
    public synchronized String make(String s, String login) {
        getMaker().getHistory_list().add("remove by id");
        long id;
        try {
            id = Long.parseLong(s);
        } catch (Exception ex) {
            return "Неверный тип аргумента";
        }
        int tmp = getMaker().getDragons().size();
        getMaker().getDragons().removeIf(p -> p.getId() == id && p.getLogin().equalsIgnoreCase(login));
        getMaker().save();
        if (tmp == getMaker().getDragons().size())
            return "В коллекции нет элемента с id " + id + " или вы не имеете к нему доступ.";
        else
            return "Элемент успешно удаленю";
    }
}
