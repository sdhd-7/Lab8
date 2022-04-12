package clie;

import programm.defaults.*;
import programm.helper.MessagePacket;

import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.time.LocalDateTime;
import java.util.Scanner;

public class ClientConnection {
    private final Scanner input;
    private InetAddress host;
    private int port;

    public ClientConnection(Scanner input, InetAddress host, int port) {
        this.input = input;
        this.host = host;
        this.port = port;
    }

    public void go() throws IOException, ClassNotFoundException {
        while (input.hasNextLine()) {

            String sinp = input.nextLine();
            String[] scom = sinp.trim().split(" ");
            MessagePacket packet = new MessagePacket();
            Dragon tmp;
            switch (scom[0]) {
                case "":
                    break;
                case "help":
                case "show":
                case "remove_first":
                case "history":
                case "info":
                case "clear":
                    if (scom.length != 1) {
                        wrong();
                        break;
                    }
                    packet = new MessagePacket(scom[0]);
                    break;
                case "exit":
                    if (scom.length != 1) {
                        wrong();
                        break;
                    }
                    System.exit(0);
                    break;
                case "add":
                case "add_if_max":
                    if (scom.length != 1) {
                        wrong();
                        break;
                    }
                    tmp = newDragon();
                    packet = new MessagePacket(scom[0], tmp);
                    break;
                case "update":
                    if (scom.length != 2) {
                        wrong();
                        break;
                    }
                    long tmpid;
                    try {
                        tmpid = Long.parseLong(scom[1]);
                    } catch (Exception e) {
                        wrong();
                        break;
                    }
                    tmp = newDragon();
                    tmp.setId(tmpid);
                    packet = new MessagePacket(scom[0], tmp);
                    break;
                case "remove_by_id":
                case "remove_all_by_type":
                case "count_by_age":
                case "filter_by_character":
                    if (scom.length != 2) {
                        wrong();
                        break;
                    }
                    packet = new MessagePacket(scom[0], scom[1]);
                    break;
                default:
                    wrong();
                    break;
            }

            if (packet.isUse()) {
                System.out.println(send(packet));
            }
        }
    }

    private Dragon newDragon() {
        //создание нового объекта
        Dragon temp = new Dragon();

        temp.setId((long) (Math.random() * 543323));

        //присвоение имени дракона
        String tmp;
        System.out.println("Введите имя дракона: ");
        tmp = input.nextLine();
        while (tmp.equals("")) {
            System.out.println("Имя не может быть пустым, введите Имя: ");
            tmp = input.nextLine();
        }
        temp.setName(tmp);

        //дата создания
        temp.setCreationDate(LocalDateTime.now());

        //age
        System.out.println("Введите возраст дракона: ");
        tmp = input.nextLine();
        int age;
        if (!tmp.equals("")) {
            age = Integer.parseInt(tmp);
            while (age <= 0) {
                System.out.println("Возраст не может быть меньше нуля: ");
                age = Integer.parseInt(input.nextLine());
            }
            temp.setAge(age);
        }

        //speak
        System.out.println("Умеет ли дракон разговаривать Y/N?: ");
        tmp = input.nextLine();
        while (!(tmp.equals("Y") || tmp.equals("N"))) {
            System.out.println("Умеет ли дракон разговаривать, введите Y/N?: ");
            tmp = input.nextLine();
        }
        temp.setSpeaking(tmp.equals("Y"));

        //coordinates x y
        System.out.println("Введите координату X: ");
        long x = Long.parseLong(input.nextLine());
        while (x <= -198) {
            System.out.println("Введите координату X, она должна быть больше -198: ");
            x = Long.parseLong(input.nextLine());
        }

        System.out.println("Введите координату Y: ");
        long y = Long.parseLong(input.nextLine());
        while (y <= -198) {
            System.out.println("Введите координату Y, она должна быть больше -198: ");
            y = Long.parseLong(input.nextLine());
        }

        temp.setCoordinates(new Coordinates(x, y));

        //dragon type
        boolean fl = true;
        while (fl) {
            System.out.println("Выберите один из данных типов дракона\nWATER\n" +
                    "UNDERGROUND\n" +
                    "AIR\n" +
                    "FIRE");
            tmp = input.nextLine();
            fl = false;
            switch (tmp) {
                case "UNDERGROUND" -> temp.setType(DragonType.UNDERGROUND);
                case "WATER" -> temp.setType(DragonType.WATER);
                case "AIR" -> temp.setType(DragonType.AIR);
                case "FIRE" -> temp.setType(DragonType.FIRE);
                default -> fl = true;
            }
        }

        //dragon character
        fl = true;
        while (fl) {
            System.out.println("Выберите один из данных характеров дракона\nWISE\n" +
                    "EVIL\n" +
                    "CHAOTIC_EVIL\n" +
                    "FICKLE");
            tmp = input.nextLine();
            fl = false;
            switch (tmp) {
                case "EVIL" -> temp.setCharacter(DragonCharacter.EVIL);
                case "WISE" -> temp.setCharacter(DragonCharacter.WISE);
                case "CHAOTIC_EVIL" -> temp.setCharacter(DragonCharacter.CHAOTIC_EVIL);
                case "FICKLE" -> temp.setCharacter(DragonCharacter.FICKLE);
                default -> fl = true;
            }
        }

        //Killer

        System.out.println("Жив ли дракон? Y/N");

        tmp = input.nextLine();
        while (!(tmp.equals("Y") || tmp.equals("N"))) {
            System.out.println("Жив ли дракон, введите Y/n?: ");
            tmp = input.nextLine();
        }
        if (tmp.equals("Y")) {
            temp.setKiller(null);
        } else {
            Person lol = new Person();

            //name killer
            System.out.println("Введите имя драконоборца: ");
            tmp = input.nextLine();
            while (tmp.equals("")) {
                //System.out.println("Имя не может быть пустым, введите имя: ");
                tmp = input.nextLine();
            }
            lol.setName(tmp);

            //killer passport
            System.out.println("Введите паспорт драконоборца: ");
            tmp = input.nextLine();
            while (!(tmp.length() < 35 && tmp.length() >= 4 || tmp.length() == 0)) {
                System.out.println("количество символов в паспорте должно быть не меньше 4 и не больше 34, введите паспорт: ");
                tmp = input.nextLine();
            }
            if (tmp.length() != 0)
                lol.setPassportID(tmp);

            //hair color
            {
                fl = true;
                while (fl) {
                    System.out.println("Выберите один из данных цветов волос драконоборца\n" +
                            "BLACK\n" +
                            "BLUE\n" +
                            "WHITE\n" +
                            "YELLOW\n" +
                            "BROWN");
                    tmp = input.nextLine();
                    fl = false;
                    switch (tmp) {
                        case "BLACK" -> lol.setHairColor(Color.BLACK);
                        case "BLUE" -> lol.setHairColor(Color.BLUE);
                        case "WHITE" -> lol.setHairColor(Color.WHITE);
                        case "YELLOW" -> lol.setHairColor(Color.YELLOW);
                        case "BROWN" -> lol.setHairColor(Color.BROWN);
                        case "" -> lol.setHairColor(null);
                        default -> fl = true;
                    }
                }
            }

            //eyes color
            {
                fl = true;

                while (fl) {
                    System.out.println("Выберите один из данных цветов зрачка драконоборца\n" +
                            "BLACK\n" +
                            "BLUE\n" +
                            "WHITE\n" +
                            "YELLOW\n" +
                            "BROWN");
                    tmp = input.nextLine();
                    fl = false;
                    switch (tmp) {
                        case "BLACK" -> lol.setEyeColor(Color.BLACK);
                        case "BLUE" -> lol.setEyeColor(Color.BLUE);
                        case "WHITE" -> lol.setEyeColor(Color.WHITE);
                        case "YELLOW" -> lol.setEyeColor(Color.YELLOW);
                        case "BROWN" -> lol.setEyeColor(Color.BROWN);
                        case "" -> lol.setEyeColor(null);
                        default -> fl = true;
                    }

                }
            }

            //nationality

            {
                fl = true;
                while (fl) {
                    System.out.println("Выберите одну из данных национальностей драконоборца\n" +
                            "GERMANY\n" +
                            "ITALY\n" +
                            "SOUTH_KOREA");
                    tmp = input.nextLine();
                    fl = false;
                    switch (tmp) {
                        case "GERMANY" -> lol.setNationality(Country.GERMANY);
                        case "ITALY" -> lol.setNationality(Country.ITALY);
                        case "SOUTH_KOREA" -> lol.setNationality(Country.SOUTH_KOREA);
                        case "" -> lol.setHairColor(null);
                        default -> fl = true;
                    }
                }
            }

            //location
            {
                System.out.println("Знаете ли вы месторасположение драконоборца? Y/N");

                tmp = input.nextLine();
                while (!(tmp.equals("Y") || tmp.equals("N"))) {
                    System.out.println("Знаете ли вы месторасположение драконоборца, введите Y/N?: ");
                    tmp = input.nextLine();
                }
                if (tmp.equals("N")) {
                    lol.setLocation(null);
                } else {
                    System.out.println("Введите координату X: ");
                    tmp = input.nextLine();
                    while (tmp.equals("")) {

                        System.out.println("Введите координату X: ");
                        tmp = input.nextLine();
                    }
                    x = Long.parseLong(tmp);
                    System.out.println("Введите координату Y: ");
                    tmp = input.nextLine();
                    while (tmp.equals("")) {

                        System.out.println("Введите координату Y: ");
                        tmp = input.nextLine();
                    }
                    y = Long.parseLong(tmp);
                    System.out.println("Укажите название местности: ");
                    tmp = input.nextLine();
                    while (tmp.equals("")) {

                        System.out.println("Укажите название местности: ");
                        tmp = input.nextLine();
                    }
                    lol.setLocation(new Location(x, y, tmp));
                }
            }
            temp.setKiller(lol);
        }
        return temp;
    }

    private String send(MessagePacket packet) throws IOException, ClassNotFoundException {

        ByteArrayOutputStream baos = new ByteArrayOutputStream(2048);
        ObjectOutputStream oos = new ObjectOutputStream(baos);

        oos.writeObject(packet);
        byte[] arr = baos.toByteArray(), ars = new byte[4096];
        DatagramSocket ds = new DatagramSocket();
        DatagramPacket dps = new DatagramPacket(arr, arr.length, host, port);
        ds.send(dps);
        DatagramPacket dpr = new DatagramPacket(ars, ars.length);
        ds.receive(dpr);

        ByteArrayInputStream bis = new ByteArrayInputStream(ars);
        ObjectInputStream oin = new ObjectInputStream(bis);
        MessagePacket tmp = (MessagePacket) oin.readObject();
        return tmp.getComm();
    }

    /**
     * Уведомляет пользователя о неверно введенной команде.
     */
    private void wrong() {
        System.out.println("Введена неверная команда, чтобы ознакомиться со списком доступных команд, введите команду help");
    }

}
