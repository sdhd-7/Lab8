package commands;

import serv.Init;

public class RemoveFirstComm extends AbstractComm{
    public RemoveFirstComm(Init m){
        super(m);
    }
    @Override
    public synchronized String make(){
        getMaker().getHistory_list().add("remove first");
        if (getMaker().getDragons().size() == 0)
            return "Коллекция пуста";
        else {
            getMaker().getDragons().remove(0);
            return "Первый элемент успешно удален";
        }
    }
}
