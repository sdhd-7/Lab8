package commands;

import programm.defaults.Dragon;
import serv.Init;

public class AgeComm extends AbstractComm{
    public AgeComm(Init maker){
        super(maker);
    }

    @Override
    public synchronized String make(String s){
        getMaker().getHistory_list().add("count by age");
        int age;
        try {
            age = Integer.parseInt(s);
        }
        catch (Exception ex){
            return "Неверный формат возраста.";
        }
        int count = 0;
        for (Dragon tmp : getMaker().getDragons()) {
            if (tmp.getAge() == age)
                count++;
        }
        return "В коллекции нашлось " + count + " драконов в возрасте " + age;
    }
}
