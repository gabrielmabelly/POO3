package etp7;

import java.io.*;
import java.net.Socket;

public class TestClientTCP {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Saisir l'ip du serveur : ");
        String ip = br.readLine();


        Socket socket = new Socket(ip, 4848);
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
        DataInputStream dis = new DataInputStream(socket.getInputStream());
        System.out.println("Connecté");
        System.out.print("Saisir du texte : ");
        String texte = br.readLine();

        dos.writeUTF(texte);
        dos.flush();

        String ligneserveur = dis.readUTF();
        System.out.println("Reçu du serveur : ");
        System.out.println(ligneserveur);

        dos.close();
        dis.close();
        br.close();
        socket.close();
    }
}
