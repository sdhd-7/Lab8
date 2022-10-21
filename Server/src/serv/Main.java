package serv;

import classes.DragonCharacter;
import managers.DBManager;

import java.io.IOException;
import java.net.InetAddress;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException, SQLException {

        String t = "WISE";
        DragonCharacter tmp;
        tmp = DragonCharacter.valueOf(t);
        System.out.println(tmp);

        DBManager.getInstance();
        ServConnection serv = new ServConnection(1338);
        System.out.println(InetAddress.getLoopbackAddress());
        System.out.println(InetAddress.getLocalHost());

        serv.go();

        //System.out.println(new ShowComm(maker).make());

    }
}
