package etp7;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class TableauClient {

    public static void main(String[] args) throws IOException {
        int[] tableau = new int[]{3,6,9,6,9,3,369693};
        Socket socket = new Socket("localhost", 7001);
        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());

        System.out.println("Envoi du tableau");
        oos.writeObject(tableau);

        oos.close();
        socket.close();
    }
}
