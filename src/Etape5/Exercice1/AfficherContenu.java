package Etape5.Exercice1;

import java.io.*;

public class AfficherContenu
{
    public static void main(String[] args)
    {
        try
        {
            afficherFichier(".\\src\\Etape5\\Exercice1\\test");
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }


    public static void afficherFichier(String nomFichier) throws IOException
    {
        BufferedReader reader = new BufferedReader(new FileReader(nomFichier));

        String line;
        while ((line = reader.readLine()) != null)
        {
            System.out.println(line);
        }

    }
}
