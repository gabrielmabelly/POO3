package Etape7.Exercice2;

import java.io.*;
import java.net.Socket;

public class ChaussettesClientTCP
{
    public static void main(String[] args) throws IOException
    {
        int[] tab = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        try
        {
            Socket socketClient = new Socket("localhost", 4848);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socketClient.getOutputStream());
            DataInputStream dataInputStream = new DataInputStream(socketClient.getInputStream());

            System.out.println("Connecté au serveur.");


            objectOutputStream.writeObject(tab); // On envoie le tableau d'entiers que l'on a créé


            String serverAnswer = dataInputStream.readUTF();
            System.out.println("Réponse du serveur : " + serverAnswer);

            objectOutputStream.close();
            dataInputStream.close();
            bufferedReader.close();
            socketClient.close();

        } catch (Exception e)
        {
            e.printStackTrace();
            System.err.println("Veillez à bien lancer le serveur.");
        }
        System.out.println("Fin du programme.");


    }
}
