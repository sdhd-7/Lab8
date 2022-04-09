package commands;

import programm.defaults.Dragon;
import serv.Init;

public class FilterByCharacterComm extends AbstractComm{
    public FilterByCharacterComm(Init m){
        super(m);
    }
    @Override
    public synchronized String make(String s){
        getMaker().getHistory_list().add("filter by character");
        int k = 0;
        StringBuilder ans = new StringBuilder();
        for (Dragon c : getMaker().getDragons()) {
            if (s.equals(c.getCharacter().toString())) {
                k++;
                ans.append(k).append(") ").append(getMaker().getGson().toJson(c)).append('\n');
            }
        }
        if (k == 0) {
            return"""
                    В наборе нет драконов с данным характером или вы указали неверный характер.
                    Ниже список существующих характеров:WISE
                    EVIL
                    CHAOTIC_EVIL
                    FICKLE""";
        }
        return ans.toString();
    }
}
