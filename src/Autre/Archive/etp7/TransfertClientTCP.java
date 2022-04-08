package etp7;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class TransfertClientTCP {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Socket socket = new Socket("localhost", 7001);
        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
        DataInputStream dis = new DataInputStream(socket.getInputStream());
        Scanner sc = new Scanner(System.in);

        DirView dirView = (DirView) ois.readObject();
        System.out.println("DirView reçu");

        dirView.afficher();

        System.out.print("Choisir fichier : ");
        dos.writeInt(sc.nextInt());
        String nomfichier = dis.readUTF();


        System.out.println(nomfichier);

        InputStreamReader isr = new InputStreamReader(socket.getInputStream());
        BufferedReader br = new BufferedReader(isr);
        File file = new File("tmp/" + nomfichier);
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(file));
        String line = br.readLine();
        while (line != null) {
            osw.write(line + '\n');
            line = br.readLine();
        }


        osw.close();
        isr.close();
        br.close();
        dos.close();
        oos.close();
        ois.close();
        socket.close();
    }
}
