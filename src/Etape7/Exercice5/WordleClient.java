package Etape7.Exercice5;

import java.io.*;
import java.net.Socket;

public class WordleClient
{
    public void game()
    {
        boolean flag = false;
        int i = 0;
        String essai;
        try
        {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            Socket socketClient = new Socket("localhost", 4242);
            DataOutputStream dataOutputStream = new DataOutputStream(socketClient.getOutputStream());
            DataInputStream dataInputStream = new DataInputStream(socketClient.getInputStream());


            while (!flag && i <= 5)
            {
                System.out.println("Essai n°" + (i + 1) + " , entrez votre mot :"); // Pour que ce soit plus 'humain' on part de 1
                essai = bufferedReader.readLine();

                if (essai.length() != 5) // Vérification que le joueur a bien entré un mot de 5 carctères
                {
                    System.err.println("Merci d'entrer un mot de 5 lettres.");
                    continue; // Repart dans la boucle sans incrémenter i
                }


                dataOutputStream.writeUTF(essai);
                dataOutputStream.flush();

                String answer = dataInputStream.readUTF(); // Réponse serveur après notre tentative
                if (answer.contains("Gagné"))
                    flag = true;

                System.out.println(answer);

                i++; // Permet d'éviter de repartir dans la boucle


            }


        } catch (Exception e)
        {
            e.printStackTrace();
        }


    }


    public static void main(String[] args)
    {
        WordleClient wordleClient = new WordleClient();
        wordleClient.game();


    }
}
