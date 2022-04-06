package Etape6.Exercice3;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class WordInDirectory
{
    public static void main(String[] args)
    {
        testAllFiles(args[0], args[1]);
    }


    public static void testAllFiles(String mot, String folder)
    {
        File rootFolder = new File(folder);
        File[] listFiles = rootFolder.listFiles();

        if (rootFolder.exists() && rootFolder.isDirectory())
        {

            if (listFiles == null ||listFiles.length == 0 )
            {
                System.out.println("Le dossier " + rootFolder.getPath() + " est vide.");
            } else
            {
                for (File file : listFiles)
                {
                    if (file.isDirectory())
                    {
                        testAllFiles(mot, file.getPath());
                    } else
                    {
                        try
                        {
                            if (wordInFile(mot, file.getPath()))
                            {
                                System.out.print("Mot trouvé dans le fichier suivant : ");
                                System.out.println(file.getAbsolutePath());
                            }
                        } catch (Exception e)
                        {
                            System.out.println("caca2");
                            e.printStackTrace();
                        }
                    }
                }
            }
        } else
        {
            System.err.println("Le fichier n'existe pas / n'est pas un répertoire.");
        }
    }


    public static boolean wordInFile(String word, String fileName)
    {

        File file = new File(fileName);


        if (file.exists())
        {
            try
            {
                if (Files.probeContentType(file.toPath()).equals("text/plain")) // Attention ! Après quelques dizaines de minutes de perdues, ce calcul renvoie null si appliqué à un fichier .rar
                {
                    List<String> stringStream = Files.readAllLines(file.toPath());
                    int cpt = 0;
                    for (String s : stringStream)
                    {
                        if (s.contains(word))
                        {
                            cpt++;
                        }
                    }

                    if (cpt > 0)
                        return true;
                    else
                        return false;
                } else
                {
                    System.out.println("Le type de fichier est incorrect.");
                    return false;
                }


            } catch (Exception e)
            {
                System.err.println("Fichier potentiellement non pris en charge par probeContentType / autre erreur.");
                e.printStackTrace();
                return false;
            }
        } else
        {
            System.out.println("Le fichier n'a pas été trouvé.");
            return false;
        }
    }
}
