package Etape7.Exercice1;

import java.io.*;
import java.net.Socket;

public class testClientTCP
{
    public static void main(String[] args) throws IOException
    {
        String IPAdress;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Entrez l'adresse ip du serveur : "); // IP = 127.0.0.1 (apparemment)
        IPAdress = bufferedReader.readLine();

        Socket socketClient = new Socket(IPAdress, 4848);
        DataOutputStream dataOutputStream = new DataOutputStream(socketClient.getOutputStream());
        DataInputStream dataInputStream = new DataInputStream(socketClient.getInputStream());

        System.out.println("Connecté au serveur.");
        System.out.println("Entrez du texte à envoyer au serveur : ");

        dataOutputStream.writeUTF(bufferedReader.readLine()); // Envoi au serveur du texte que l'on vient d'entrer
        dataOutputStream.flush();

        String serverAnswer = dataInputStream.readUTF();
        System.out.println("Réponse du serveur : " + serverAnswer);

        dataOutputStream.close();
        dataInputStream.close();
        bufferedReader.close();
        socketClient.close();



    }
}
