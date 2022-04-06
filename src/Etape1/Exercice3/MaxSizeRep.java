package Etape1.Exercice3;

import java.io.File;

public class MaxSizeRep {

    public static void startFonction(File startFolder) {
        File[] folderList = startFolder.listFiles();
        File biggest = null;
        long taille = 0;

        for (File o : folderList) {

            if (o.isDirectory()) {
                long temp = getBiggestFolder(o); // Fonction récursive qui permet de récupérer la taille du dossier
                if (temp > taille) { // Si la taille du plus grand dossier jusqu'à maintenant est inférieure à la taille du dossier courant
                    biggest = o; // On met le dossier courant dans une variable de type File
                    taille = getBiggestFolder(o); // Et on met sa taille dans une variable long
                }
            }
        }
        System.out.println("Biggest folder is : " + biggest.getName() + " and its size is : " + taille + " bytes."); // Affichage du plus grand dossier après exécution de la fonction
    }


    /**
     * @param dossierCourant Variable de type File
     * @return Renvoit la taille du dossier courant
     */
    public static long getBiggestFolder(File dossierCourant) {
        File[] listFiles = dossierCourant.listFiles();
        long size = 0;

        for (File o : listFiles) {
            size = size + o.length();
            if (o.isDirectory()) {
                size = size + getBiggestFolder(o);
            }
        }

        return size;
    }


    public static void main(String[] args) {

        File repertoire = new File(args[0]);

        if (repertoire.exists())
            startFonction(repertoire);
            // La première fonction est appelée lorque le répertoire existe, cette fonction va appeler la fonction récursive qui permettra de trouver le dossier le plus grand
        else
            System.out.println("Le répertoire donné en argument n'existe pas : " + repertoire.getPath());
            // Lorsque le chemin n'est pas correct on l'affiche afin que l'utilisateur puisse trouver son erreur et relancer le programme

    }
}


