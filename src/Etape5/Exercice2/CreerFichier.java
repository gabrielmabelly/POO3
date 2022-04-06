package Etape5.Exercice2;


import java.io.*;
import java.nio.file.FileAlreadyExistsException;

public class CreerFichier
{
    public static void main(String[] args) throws FileAlreadyExistsException
    {
        try
        {
            writeFile(args[0]);
        } catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    public static void writeFile(String nomFichier) throws IOException
    {
        File file = new File(nomFichier);
        if (file.isFile() || file.isDirectory())
        {
            throw new FileAlreadyExistsException("Le fichier existe déjà ou est un répertoire.");
        } else
        {
            try
            {
                InputStreamReader inputStreamReader = new InputStreamReader(System.in);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                FileWriter fileWriter = new FileWriter(file);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

                System.out.println("Saisir une ligne de texte : ");
                bufferedWriter.write(bufferedReader.readLine());

            } catch (Exception e)
            {
                e.printStackTrace();
            }
        }

    }


}
