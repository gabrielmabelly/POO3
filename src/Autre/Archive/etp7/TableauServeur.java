package etp7;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TableauServeur {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ServerSocket serversocket = new ServerSocket(7001);
        Socket socket = serversocket.accept();

        ObjectInputStream dis = new ObjectInputStream(socket.getInputStream());

        System.out.println("Récupération du tableau");
        int[] tableau = (int[]) dis.readObject();
        for (int i : tableau) {
            System.out.println(i);
        }

        dis.close();
        socket.close();
        serversocket.close();

    }
}
