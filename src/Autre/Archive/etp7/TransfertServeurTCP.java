package etp7;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;

public class TransfertServeurTCP {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ServerSocket serversocket = new ServerSocket(7001);
        Socket socket = serversocket.accept();

        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
        DataInputStream dis = new DataInputStream(socket.getInputStream());
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

        DirView dirView = new DirView("src/etp7");

        oos.writeObject(dirView);

        System.out.println("Objet envoyé");
        int choixFichier = dis.readInt();
        System.out.println(choixFichier);

        dos.writeUTF(dirView.recupFichier(choixFichier).getName());
        dos.flush();

        FileReader fr = new FileReader(dirView.recupFichier(choixFichier));
        BufferedReader br = new BufferedReader(fr);
        PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
        do {
            String l = br.readLine();
            pw.println(l);
        } while (br.ready());

        br.close();
        fr.close();
        pw.close();
        dis.close();
        ois.close();
        oos.close();
        socket.close();
        serversocket.close();

    }
}
