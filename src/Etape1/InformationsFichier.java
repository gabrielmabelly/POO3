package Etape1;

import java.io.File;

public class InformationsFichier
{
    public static void main(String[] args)
    {
        File f = new File(args[0]);
        System.out.println("Chemin absolu : " + f.getAbsolutePath());
        System.out.println("Fichier existe : " + f.exists());
        System.out.println("Est un répertoire : " + f.isDirectory());
        if (f.exists())
        {
            File[] listeFichiers = f.listFiles();
            for (File var : listeFichiers)
            {
                if (var.isDirectory())
                {
                    System.out.print("Nom répertoire : ");
                    System.out.println(var.getName());
                } else
                {
                    System.out.print("Nom fichier : " + var.getName() + "sa taille (en octet) est de : " + var.length() + "\n");
                    System.out.println("Lecture : " + var.canRead() + "\t Ecriture : " + var.canWrite() + "\t Execution : " + var.canExecute()
                            + "et le fichier a été modifié le : " + java.time.Instant.ofEpochMilli(var.lastModified()));
                }
            }
        }
        else
            System.out.println("Le fichier / répertoire n'existe pas");
    }
}
