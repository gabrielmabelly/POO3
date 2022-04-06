package Etape7.Exercice3;

import java.io.*;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class TransfertClientTCP
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        DirView dirviewReceived = null;

        try
        {
            Socket socketClient = new Socket("localhost", 4848);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socketClient.getOutputStream());
            ObjectInputStream objectInputStream = new ObjectInputStream(socketClient.getInputStream());

            System.out.println("Connecté au serveur.");


            try
            {
                dirviewReceived = (DirView) objectInputStream.readObject();
                System.out.println("Réponse du serveur : " + objectInputStream);
            } catch (Exception e)
            {
                System.err.println("Mauvais type envoyé.");
                e.printStackTrace();
            }
            dirviewReceived.display();

            System.out.println("Quel fichier voulez-vous synchroniser ? Entrez le numéro correspondant.");

            try
            {
                Scanner scanner = new Scanner(System.in);
                File tempFile = dirviewReceived.returnFile(scanner.nextInt());
                File temp = new File("C:\\Users\\Gabriel\\IdeaProjects\\ProgrammationOrientéeObjet3\\src\\Etape7\\Exercice3\\temp\\" + tempFile.getName());
                if (!temp.exists())
                {
                    Files.copy(
                            Paths.get
                                    (tempFile.
                                            getAbsolutePath()),
                            Paths.get(
                                    temp.getAbsolutePath()));

                } else
                {
                    temp = new File(temp.getAbsolutePath().substring(0, temp.getAbsolutePath().lastIndexOf(".")) + "-1" + temp.getAbsolutePath().substring(temp.getAbsolutePath().lastIndexOf(".")));
                    if (temp.exists())
                    {
                        System.err.println("Le fichier a déjà été synchronisé.");
                    } else
                    {
                        Files.copy(
                                Paths.get
                                        (tempFile.
                                                getAbsolutePath()),
                                Paths.get(temp.getAbsolutePath()));
                    }
                }


            } catch (Exception e)
            {
                System.err.println("Mauvais nombre entré / caractère incorrect.");
                e.printStackTrace();
            }


            objectOutputStream.close();
            objectInputStream.close();
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
