package etp7;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client {

    public static void main(String[] args) throws IOException {
        Etudiant etu1 = new Etudiant("Miceli", "Thomas", "m17004063", 22);
        Socket socket = new Socket("localhost", 7001);
        OutputStream os = socket.getOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(os);
        oos.writeObject(etu1);

        oos.close();
        os.close();
        socket.close();
    }
}
