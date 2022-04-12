package serv;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ServConnection serv = new ServConnection(1337, new Init(args[0]));
        serv.go();
        //System.out.println(new ShowComm(maker).make());

        /*ByteArrayOutputStream baos = new ByteArrayOutputStream(2048);
        ObjectOutputStream oos = new ObjectOutputStream(baos);

        oos.writeObject(maker.getDragons().get(0));
        oos.flush();
        byte[] arr = baos.toByteArray();

        byte[] arr2 = new byte[10];
        int len = arr.length;
        int len2 = 10;

        DatagramChannel dc; ByteBuffer buf, buf2;
        int port = 1337;
        SocketAddress addr = new InetSocketAddress(port);
        dc = DatagramChannel.open();
        dc.bind(addr);

        buf = ByteBuffer.wrap(arr);
        buf2 = ByteBuffer.wrap(arr);
        addr = dc.receive(buf);
        for (int j = 0; j < len; j++) {
            System.out.println(arr[j]);
        }
        System.out.println(arr.length);
        buf.flip();
        dc.send(buf2, addr);

         */
    }
}
