package etp7;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TestServeurTCP {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ServerSocket serversocket = new ServerSocket(4848);
        Socket socket = serversocket.accept();

        DataInputStream dis = new DataInputStream(socket.getInputStream());
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String texterecu = dis.readUTF();

        System.out.println("Reçu du client : ");
        System.out.println(texterecu);
        System.out.println("Répondre au client : ");
        dos.writeUTF(br.readLine());

        dos.close();
        dis.close();
        br.close();
        socket.close();
        serversocket.close();

    }
}
