package commands;

import programm.defaults.Dragon;
import serv.Init;

public class HelpComm extends AbstractComm{
    public HelpComm(Init maker){
        super(maker);
    }

    @Override
    public synchronized String make(){
        getMaker().getHistory_list().add("help");
        return "info : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)\n" +
                "show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении\n" +
                "add {element} : добавить новый элемент в коллекцию\n" +
                "update id {element} : обновить значение элемента коллекции, id которого равен заданному\n" +
                "remove_by_id id : удалить элемент из коллекции по его id\n" +
                "clear : очистить коллекцию\n" +
                "execute_script file_name : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.\n" +
                "exit : завершить программу\n" +
                "remove_first : удалить первый элемент из коллекции\n" +
                "add_if_max {element} : добавить новый элемент в коллекцию, если его значение превышает значение наибольшего элемента этой коллекции\n" +
                "history : вывести последние 15 команд (без их аргументов)\n" +
                "remove_all_by_type type : удалить из коллекции все элементы, значение поля type которого эквивалентно заданному\n" +
                "count_by_age age : вывести количество элементов, значение поля age которых равно заданному\n" +
                "filter_by_character character : вывести элементы, значение поля character которых равно заданному";
    }
}
