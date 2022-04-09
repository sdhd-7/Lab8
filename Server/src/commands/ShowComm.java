package commands;

import programm.defaults.Dragon;
import serv.Init;

public class ShowComm extends AbstractComm{
    public ShowComm(Init maker){
        super(maker);
    }
    @Override
    public synchronized String make(){
        getMaker().getHistory_list().add("show");
        StringBuilder ans = new StringBuilder();
        ans.append("В коллекции ").append(getMaker().getDragons().size()).append(" элементов:").append('\n');
        for (Dragon tmp : getMaker().getDragons())
            ans.append(getMaker().getGson().toJson(tmp)).append('\n');
        return ans.toString();
    }
}
