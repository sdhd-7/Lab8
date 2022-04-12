package serv;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ServConnection serv = new ServConnection(1337, new Init(args[0]));
        serv.go();
        //System.out.println(new ShowComm(maker).make());

    }
}
