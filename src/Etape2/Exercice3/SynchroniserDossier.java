package Etape2.Exercice3;

import java.io.*;
import java.time.LocalDate;


public class SynchroniserDossier
{
    public static void main(String[] args) throws IOException
    {
        File directory1 = new File(args[0]);
        File directory2 = new File(args[1]);
        int criteria = Integer.parseInt(args[2]);


        if (directory1.exists() && directory1.isDirectory())
        {
            if (directory2.exists() && directory2.isDirectory())
            {
                synchroniserDossier(directory1, directory2, criteria);
                System.out.println("La synchronisation a été effectuée en fonction du critère donné en entrée.");

            } else
            {
                System.err.println("Il y a un problème avec le répertoire de destination.");
            }

        } else
        {
            System.err.println("Problème avec le répertoire source.");
        }
    }


    public static void synchroniserDossier(File directory1, File directory2, int critere) throws IOException
    {
        switch (critere)
        {
            case 0:
                syncMostRecent(directory1, directory2);
                syncMostRecent(directory2, directory1);
                break;
            case 1:
                syncBiggest(directory1, directory2);
                syncBiggest(directory2, directory1);
                break;
            case 2:
                syncReference(directory1, directory2);
                break;
            case 3:
                break;

        }
    }


    public static void syncMostRecent(File directory1, File directory2) throws IOException
    {
        File[] fileList1 = directory1.listFiles();


        for (File file : fileList1)
        {
            File temp = new File(directory2.getPath() + "\\" + file.getName()); // On crée un chemin équivalent dans l'autre dossier
            if (file.isDirectory()) // On vérifie que c'est un dossier
            {
                temp = new File(directory2.getAbsolutePath() + "\\" + file.getName()); // On crée un chemin équivalent dans l'autre dossier
                temp.mkdirs();
                syncMostRecent(file, temp);
                ;
            } else
            {
                if (file.lastModified() > temp.lastModified()) // On garde le plus récent des deux dossiers
                    fileCopy(file, temp); // On copie le fichier le plus récent
            }
        }
    }


    public static void fileCopy(File source, File destination) throws IOException
    {

        FileInputStream inputStream = new FileInputStream(source);
        FileOutputStream outputStream = new FileOutputStream(destination);
        if (!(inputStream == null || outputStream == null))
        {
            while (inputStream.available() != 0)
            {
                outputStream.write(inputStream.read());
            }
            inputStream.close();
            outputStream.close();

        }

    }

    public static void syncBiggest(File directory1, File directory2) throws IOException
    {
        File[] fileList1 = directory1.listFiles();


        for (File file : fileList1)
        {
            File temp = new File(directory2.getPath() + "\\" + file.getName()); // On crée un chemin équivalent dans l'autre dossier
            if (file.isDirectory()) // On vérifie que c'est un dossier
            {
                temp = new File(directory2.getAbsolutePath() + "\\" + file.getName()); // On crée un chemin équivalent dans l'autre dossier
                temp.mkdirs();
                syncMostRecent(file, temp);
                ;
            } else
            {
                if (file.length() > temp.length()) // On garde le plus récent des deux dossiers
                    fileCopy(file, temp); // On copie le fichier le plus récent
            }
        }
    }

    public static void syncReference(File directory1, File directory2) throws IOException
    {
        File[] fileList1 = directory1.listFiles();



        deleteEverything(directory2);


        for (File file : fileList1)
        {
            File temp = new File(directory2.getPath() + "\\" + file.getName()); // On crée un chemin équivalent dans l'autre dossier
            if (file.isDirectory()) // On vérifie que c'est un dossier
            {
                temp = new File(directory2.getAbsolutePath() + "\\" + file.getName()); // On crée un chemin équivalent dans l'autre dossier
                temp.mkdirs();
                syncMostRecent(file, temp);

            } else
            {
                    fileCopy(file, temp); // On copie le fichier le plus récent
            }
        }
    }

    public static void deleteEverything(File directory)
    {
        File[] listFiles = directory.listFiles();

        for (File file : listFiles)
        {
            if (file.isDirectory())
            {
                deleteEverything(file);
            }
            file.delete();
        }
    }

}







