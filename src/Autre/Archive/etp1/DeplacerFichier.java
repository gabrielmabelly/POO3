package etp1;

import java.io.File;
import java.util.Date;

public class DeplacerFichier {

    public void deplacerFichier(String source, String destination) {
        File fsource = new File(source);
        File fdest = new File(destination);
        if (fsource.exists() && fsource.isFile()) {
            if (!fdest.exists()) {
                boolean success = fsource.renameTo(fdest);

                if (success) {
                    System.out.print("Fichier renommé.");
                } else {
                    System.out.print("Fichier non renommé.");
                }
            } else {
                System.out.println("Le fichier de destination existe déjà.");
            }
        } else {
            System.out.println("Erreur : le fichier demandé n'existe pas.");
        }
    }

    public static void main(String[] args) {
        new DeplacerFichier().deplacerFichier("/Users/thomas/Dev/fichier", "/Users/thomas/Dev/monfichier");
    }
}
