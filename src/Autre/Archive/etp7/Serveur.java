package etp7;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Serveur {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ServerSocket serversocket = new ServerSocket(7001);
        Socket socket = serversocket.accept();

        ObjectInputStream dis = new ObjectInputStream(socket.getInputStream());
        Etudiant etu = (Etudiant) dis.readObject();
        System.out.println(etu);

    }
}
