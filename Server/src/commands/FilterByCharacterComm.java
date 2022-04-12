package commands;

import serv.Init;

public class FilterByCharacterComm extends AbstractComm {
    public FilterByCharacterComm(Init m) {
        super(m);
    }

    @Override
    public synchronized String make(String s) {
        getMaker().getHistory_list().add("filter by character");
        StringBuilder ans = new StringBuilder();
        getMaker().getDragons().stream().filter(x -> s.equalsIgnoreCase(x.getCharacter().toString())).forEachOrdered(x -> ans.append(getMaker().getGson().toJson(x)).append('\n'));
        return (ans.toString().length() > 0) ? ans.toString() :
                "В наборе нет драконов с данным характером или вы указали неверный характер." + '\n' +
                        "Ниже список существующих характеров:" + '\n' +
                        "WISE" + '\n' +
                        "EVIL" + '\n' +
                        "CHAOTIC_EVIL" + '\n' +
                        "FICKLE";

    }
}
