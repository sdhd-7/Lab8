package commands;

import classes.Dragon;
import serv.Init;

public class AddComm extends AbstractComm {
    public AddComm(Init maker) {
        super(maker);
    }

    @Override
    public synchronized String make(Dragon arg) {
        getMaker().getHistory_list().add("add");
        arg.setId((long) (Math.random() * 543323));
        getMaker().getDragons().add(arg);
        getMaker().save();
        return "Элемент успешно добавлен.";
    }
}
