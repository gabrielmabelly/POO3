package Etape7.Exercice5;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Random;

public class WordleServer
{
    private File fichierMots;
    private ArrayList<String> mots5Lettres;
    private String motCourant;
    private int essai;

    public WordleServer() throws IOException
    {
        this.fichierMots = new File(".\\src\\Etape7\\Exercice5\\mots.txt");
        this.mots5Lettres = new ArrayList<>();
        this.essai = 0;

        for (String s : Files.readAllLines(Paths.get(fichierMots.getAbsolutePath())))
        {
            if (s.length() == 5)
                this.mots5Lettres.add(s);
        }
        newRandomWord();
        System.out.println(motCourant); // Permet de tester tous les cas plus facilement
    }

    private void newRandomWord()
    {
        this.motCourant = this.mots5Lettres.get(new Random().nextInt(this.mots5Lettres.size()));
    }

    public String returnAnswerToClient(String clientAnswer)
    {
        char[] answer = ".....".toCharArray();

        if (motCourant.contains(clientAnswer))
            answer = "11111".toCharArray();

        for (int i = 0; i < this.motCourant.length(); i++)
        {
            if (this.motCourant.charAt(i) == clientAnswer.charAt(i))
            {
                answer[i] = '1'; // Affiche si les caractères entrés par le joueurs correspondent au mot tiré
            } else
            {
                answer[i] = '0'; // Quand le caractère donné n'est pas le bon
            }
        }
        return String.valueOf(answer); // Renvoie la chaine affichant si les caractères sont corrects
    }


    public void game() throws IOException
    {
        ServerSocket serverSocket = new ServerSocket(4242);
        Socket socket = serverSocket.accept();

        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
        DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());

        boolean flag = false;
        while (essai <= 5  && !flag)
        {
            String msg = dataInputStream.readUTF();
            String temp = this.returnAnswerToClient(msg);

            if (essai == 5)
            {
                dataOutputStream.writeUTF("Perdu ! Le mot était : " + this.motCourant);
            }

            if (temp.equals("11111"))
            {
                dataOutputStream.writeUTF(temp + "\n Gagné ! Le mot est : " + this.motCourant);
                flag = true; // Évite de repartir dans la boucle si le joueur a gagné (et donc de causer des exceptions)
            }
            else
                dataOutputStream.writeUTF(temp); // Si le nb max d'essai n'est pas atteint
            // et que le joueur n'a pas gagné, on renvoie la chaine indiquant si les carctères sont corrects




            essai++; // Évite de repartir dans la boucle

        }
    }

    public static void main(String[] args) throws IOException
    {
        WordleServer wordleServer = new WordleServer();
        wordleServer.game();


    }
}
