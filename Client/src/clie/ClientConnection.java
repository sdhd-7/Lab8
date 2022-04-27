package clie;

import classes.*;

import java.io.*;
import java.math.BigInteger;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.util.Scanner;

public class ClientConnection {

    private final Scanner input;
    private final InetAddress host;
    private final int port;

    public ClientConnection(Scanner input, InetAddress host, int port) {
        this.host = host;
        this.input = input;
        this.port = port;
    }

    public void go() throws IOException, ClassNotFoundException {
        String login = null, password, kek = "";
        while (!(kek.equalsIgnoreCase("Успешная авторизация") ||
                kek.equalsIgnoreCase("Успешное добавление пользователя и авторизация"))) {
            System.out.println("Введите логин, если у вас еще нет аккаунта, введите 'reg'");

            login = input.nextLine();
            MessagePacket log;
            if (login.equalsIgnoreCase("reg")) {
                System.out.println("Введите желаемый логин:");
                login = input.nextLine();
                System.out.println("Введите желаемый пароль:");
                password = input.nextLine();
                log = new MessagePacket("newlogin", SHA512(password), login);
            } else {
                System.out.println("Введите пароль:");
                password = input.nextLine();
                log = new MessagePacket("login", SHA512(password), login);
            }
            //System.out.println(SHA512(password));
            kek = send(log);
            System.out.println(kek);
        }
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
                    packet = new MessagePacket(scom[0], login);
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
                    tmp.setLogin(login);
                    packet = new MessagePacket(scom[0], tmp, login);
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
                    tmp.setLogin(login);
                    packet = new MessagePacket(scom[0], tmp, login);
                    break;
                case "remove_by_id":
                case "remove_all_by_type":
                case "count_by_age":
                case "filter_by_character":
                    if (scom.length != 2) {
                        wrong();
                        break;
                    }
                    packet = new MessagePacket(scom[0], scom[1], login);
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
            System.out.println("""
                    Выберите один из данных типов дракона
                    WATER
                    UNDERGROUND
                    AIR
                    FIRE""");
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
            System.out.println("""
                    Выберите один из данных характеров дракона
                    WISE
                    EVIL
                    CHAOTIC_EVIL
                    FICKLE""");
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

    private void wrong() {
        System.out.println("Введена неверная команда, чтобы ознакомиться со списком доступных команд, введите команду help");
    }

    private String SHA512(String in) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            byte[] messageDigest = md.digest(in.getBytes());
            BigInteger no = new BigInteger(1, messageDigest);
            return no.toString(16);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

    }
}

