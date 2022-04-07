package Etape11.Exercice5;

import java.io.File;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.*;

public class Sniffer implements Callable<List<File>>
{
    private File currentFolder;


    public Sniffer(File file)
    {
        this.currentFolder = file;
    }

    @Override
    public ArrayList<File> call()
    {
        System.out.println(Thread.currentThread().getName());

        ArrayList<File> fileArrayList = new ArrayList<>();
        LocalDate now = LocalDate.now();

        if (!this.currentFolder.isDirectory())
            return fileArrayList;


        for (File file : this.currentFolder.listFiles())
        {
            LocalDate dateFichierCourant = Instant.ofEpochMilli(file.lastModified()).atZone(ZoneId.systemDefault()).toLocalDate();

            if (dateFichierCourant.isAfter(now.minusDays(1)) && dateFichierCourant.isBefore(now.plusDays(1)))
            {
                fileArrayList.add(file);
            }
        }
        return fileArrayList;
    }


    public static void main(String[] args) throws ExecutionException, InterruptedException
    {
        File f = new File(args[0]);
        List<Sniffer> snifferArrayList = new ArrayList<>();
        List<Future<List<File>>> futureList = null; // Permettra de stocker les Future après utilisation de la méthode InvokeAll[]
        ExecutorService executorService;
        int cpt = 0;


        if (f.isDirectory())
        {
            if (f.exists())
            {
                if (f.length() > 0) // Si le dossier n'est pas vide
                {
                    System.out.println("Début exécution du programme");

                    for (File file : f.listFiles()) // On compte le nombre de thread à créer.
                    {
                        if (file.isDirectory())
                            cpt++;
                    }
                    executorService = Executors.newFixedThreadPool(cpt); // Création de la pool de Thread en fonction du nombre de dossiers présents dans le dossier racine


                    for (File file : f.listFiles())
                    {
                        snifferArrayList.add(new Sniffer(file)); // On ajoute un sniffer par fichier présent dans le dossier source
                    }


                    futureList = executorService.invokeAll(snifferArrayList);

                    for (Future<List<File>> future : futureList)
                    {
                        List<File> fileList;
                        if (future.get() != null)
                        {
                            fileList = future.get();
                            for (File file : fileList) // future.get() renvoie une liste de File fichiers répondant aux critères +-1 jour
                            {
                                if(file.isFile())
                                {
                                    System.out.println("Dossier parent : " + file.getParent() + " nom du fichier " + file.getName());
                                }
                            }
                        }
                    }
                }
            } else
            {
                System.err.println("Merci d'entrez un chemin valide ! ");
                System.exit(-1);
            }
        } else
        {
            System.err.println("Merci d'entrez un chemin valide ! (Le chemin pointe vers un fichier et non un dossier)");
            System.exit(-1);
        }
        System.exit(0);
    }

}
