package Etape5.Exercice4;

import java.io.*;
import java.util.ArrayList;

public class GenererSite
{

    public static ArrayList<String> contentOfConfigFile(File configFile) throws IOException
    {
        FileReader fileReader = new FileReader(configFile);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        ArrayList<String> listePaths = new ArrayList<>();
        String line;

        while ((line = bufferedReader.readLine()) != null)
        {
            listePaths.add(line);
        }


        return listePaths;
    }


    public static void main(String[] args) throws IOException
    {
        File rootDirectory = new File(args[0]);

        if (rootDirectory.exists() && rootDirectory.isDirectory())
        {
            ArrayList<String> configArrayList = contentOfConfigFile(new File(rootDirectory, "config.txt"));
            String header = configArrayList.get(0);
            String footer = configArrayList.get(1);
            if (header == null || footer == null)
            {
                System.err.println("Le fichier n'a pas été configuré correctement.");
                System.exit(-1);
            }
            File fileHeader = new File(rootDirectory, header); // On crée les fichiers correspondants
            File fileFooter = new File(rootDirectory, footer); // On crée les fichiers correspondants
            File productionFolder = new File(rootDirectory, "prod"); // On crée le dossier prod dans lequel on placera les différents sites générés


            if (!(fileHeader.exists() && fileHeader.isFile()) || !(fileFooter.exists() && fileFooter.isFile())) // On teste que le heater et footer existent réellement et que ce sont des fichiers
            {
                System.err.println("Le header / footer n'est / n'existent pas / ne sont pas des fichiers.");
                System.exit(-1);
            }

            if (!productionFolder.exists())
            {
                productionFolder.mkdir(); // Création du dossier production
            }

            File tempSource = null;
            File tempTarget = null;
            // On évite le header / footer dans la boucle car ils sont placés à respectivement à l'index 0 et 1, on ira les récupérer manuellement pour écrire leur contenu dans le site généré

            BufferedReader bufferedReader;
            BufferedWriter bufferedWriter;
            for (int i = 2; i < configArrayList.size(); i++)
            {
                tempSource = new File(rootDirectory, configArrayList.get(i));
                tempTarget = new File(productionFolder, configArrayList.get(i).
                        substring(0, configArrayList.get(i).lastIndexOf('.')) + ".htm"); // On récupère le nom du fichier sans l'extension (pour pouvoir générer le .htm par la suite).
                tempTarget.createNewFile(); // Création du fichier .htm sur lequel on générera le site web

                if (tempSource.exists() && tempSource.isFile() && tempTarget.exists() && tempTarget.isFile())
                {
                    String line;
                    bufferedWriter = new BufferedWriter(new FileWriter(tempTarget));

                    bufferedReader = new BufferedReader(new FileReader(new File(rootDirectory, configArrayList.get(0))));
                    line = bufferedReader.readLine();
                    while (line != null)
                    {
                        bufferedWriter.write(line + '\n');
                        line = bufferedReader.readLine();
                    }
                    line = null;

                    bufferedReader = new BufferedReader(new FileReader(tempSource));
                    line = bufferedReader.readLine();
                    while (line != null)
                    {
                        bufferedWriter.write(line + '\n');
                        line = bufferedReader.readLine();
                    }
                    line = null;


                    bufferedReader = new BufferedReader(new FileReader(new File(rootDirectory, configArrayList.get(1))));
                    line = bufferedReader.readLine();
                    while (line != null)
                    {
                        bufferedWriter.write(line + '\n');
                        line = bufferedReader.readLine();
                    }
                    line = null;

                    bufferedWriter.close();

                } else
                {
                    System.err.println("Problème avec le fichier cible / fichier source.");
                    System.exit(-1);
                }
            }
            if (configArrayList.size() <=2 )
                System.out.println("Rien n'a été généré car les fichiers de contenu n'ont pas été trouvés dans le fichier de configuration");
            else
                System.out.println("Les sites web ont été générés.");

        } else
        {
            System.err.println("Le dossier source n'existe pas / n'est pas un dossier.");
            System.exit(-1);
        }
    }
}
