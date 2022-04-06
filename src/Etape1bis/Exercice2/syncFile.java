package Etape1bis.Exercice2;


import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.*;

public class syncFile
{
    public static void main(String[] args)
    {
        try
        {
            syncFile(Paths.get(args[0]), Paths.get(args[1]), Integer.parseInt(args[2]));
        } catch (Exception e)
        {
            System.out.println("Erreur dans les paramètres entrés :  \n " +
                    e.toString() + "\n\nMerci de recommencer avec les bons paramètres : arg0 = string, arg1 = string, arg2 = entier ");
        }
    }

    /**
     * @param p1       Chemin 1
     * @param p2       Chemin 2
     * @param criteria Entier qui permet de choisir le type de comparaison entre les fichiers présents dans p1 et p2
     */
    public static void syncFile(Path p1, Path p2, int criteria)
    {
        try
        {
            File file1 = p1.toFile();
            File file2 = p2.toFile();


            if (file1.isFile() && file2.isFile())
            {

                System.out.println("Les chemins 1 et 2 mènent à des fichiers.");
                if (file1.getName().equals(file2.getName())) // Comparaison des noms des deux fichiers
                {
                    switch (criteria)
                    {
                        case 0:
                            if (file1.lastModified() > file2.lastModified())
                            {
                                Files.copy(p1, p2, StandardCopyOption.REPLACE_EXISTING); // Garde p1 car plus récent
                            } else
                            {
                                Files.copy(p2, p1, StandardCopyOption.REPLACE_EXISTING); // Garde p2 car plus récent
                            }
                            break;
                        case 1:
                            if (file1.length() > file2.length())
                                Files.copy(p1, p2, StandardCopyOption.REPLACE_EXISTING); // Garde p1 car plus gros
                            else
                                Files.copy(p2, p1, StandardCopyOption.REPLACE_EXISTING); // Garde p2 car plus gros
                            break;
                        case 2:
                            Files.copy(p1, p2, StandardCopyOption.REPLACE_EXISTING); // On conserve p1 dans les deux dossiers
                            break;
                        case 3:
                            Files.copy(p2, p1, StandardCopyOption.REPLACE_EXISTING); // On cerserve p2 dans les deux dossiers
                            break;
                    }

                } else
                {
                    Path newFile1 = Paths.get(p2.getParent() + "\\" + p1.getFileName()); // Création des paths des fichiers à syncroniser
                    Path newFile2 = Paths.get(p1.getParent() + "\\" + p2.getFileName()); // Création des paths des fichiers à syncroniser


                    Files.createFile(newFile1); // Création des fichiers dans lesquels on va placer p1 ou p2
                    Files.createFile(newFile2); // Création des fichiers dans lesquels on va placer p1 ou p2

                    Files.copy(p1, newFile1, StandardCopyOption.REPLACE_EXISTING);
                    Files.copy(p2, newFile2, StandardCopyOption.REPLACE_EXISTING);

                    System.out.println("Les deux fichiers n'ont pas le même nom, les fichiers ont été copiés dans les dossiers dans lesquels ils ne sont pas présents.");

                }
            } else
            {
                // Gestion des exceptions
                if (!file1.isFile() && !file2.isFile())
                    throw new FileNotFoundException("Les deux chemins donnés en argument sont incorrects.");
                else
                {
                    if (!file1.isFile())
                        throw new FileNotFoundException("Le chemin du premier argument est incorrect.");
                    else
                        throw new FileNotFoundException("Le chemin du second argument est incorrect.");
                }
            }

        } catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}










