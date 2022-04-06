package Etape6.Exercice1;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;


public class WordInFile
{


    public static void main(String[] args) throws IOException
    {
        try
        {
            if (wordInFile(args[0], args[1]))
            {
                System.out.println("Le mot a été trouvé.");

            } else
                System.out.println("Le mot n'a pas été trouvé.");
        } catch (Exception e)
        {
            System.err.println("Problème lors de l'exécution voir ci-dessous : \n");
            e.printStackTrace();
        }


    }

    public static boolean wordInFile(String word, String fileName) throws IOException
    {
        File file = new File(fileName);

        if (file.exists())
        {
            if (Files.probeContentType(file.toPath()).equals("text/plain"))
            {
                List<String> stringStream = Files.readAllLines(file.toPath());
                int cpt = 0;
                for (String s : stringStream)
                {
                    if (s.contains(word))
                    {
                        System.out.println("Mot trouvé dans la chaine suivante : " + s);
                        cpt++;
                    }
                }

                if (cpt > 0)
                    return true;
                else
                    return false;
            }
            else
            {
                System.out.println("Le type de fichier est incorrect.");
                return false;
            }
        } else
        {
            System.out.println("Le ficher n'a pas été trouvé.");
            return false;
        }

    }


}
