package commands;

import programm.defaults.Dragon;
import serv.Init;

public class UpdateComm extends AbstractComm{
    public UpdateComm(Init m){
        super(m);
    }
    @Override
    public synchronized String make(Dragon arg){
        try {
            getMaker().getHistory_list().add("update by id");
            Dragon tmp = getMaker().getDragons().stream().filter(x -> x.getId() == arg.getId()).findFirst().get();
            getMaker().getDragons().remove(tmp);
            getMaker().getDragons().add(arg);
            return "Элемент с id " + arg.getId() + " успешно обновлен.";
        }
        catch (Exception e){
            return "В коллекции нет элемента с id " + arg.getId();
        }
    }
}
