package serv;

import managers.DBManager;

import java.io.IOException;
import java.net.InetAddress;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        DBManager.getInstance();
        ServConnection serv = new ServConnection(1337, new Init());
        System.out.println(InetAddress.getLocalHost());
        serv.go();

        //System.out.println(new ShowComm(maker).make());

    }
}
