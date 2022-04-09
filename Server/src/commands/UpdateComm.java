package commands;

import programm.defaults.Dragon;
import serv.Init;

public class UpdateComm extends AbstractComm{
    public UpdateComm(Init m){
        super(m);
    }
    @Override
    public synchronized String make(Dragon arg){
        getMaker().getHistory_list().add("update by id");
        int ind = -1;
        for (int i = 0; i < getMaker().getDragons().size(); ++i) {
            if (getMaker().getDragons().get(i).getId() == arg.getId()) {
                ind = i;
                break;
            }
        }
        if (ind == -1) {
            return "В коллекции нет элемента с id " + arg.getId();
        }
        getMaker().getDragons().set(ind, arg);
        return "Элемент с id " + arg.getId() + " успешно обновлен.";
    }
}
