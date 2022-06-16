package commands;

import serv.Init;

public class AgeComm extends AbstractComm {
    public AgeComm() {
        super();
    }

    @Override
    public synchronized String make(String s) {
        //System.out.println("&&&&&&&&&&&&&&&&");
        Init.getInstance().getHistory_list().add("count by age");
        int age = Integer.parseInt(s);
        //System.out.println(age + "^^^^");
        int count = (int) Init.getInstance().getDragons().stream().filter(x -> x.getAge() == age).count();
        //System.out.println(count);
        return "" + count;
    }
}
