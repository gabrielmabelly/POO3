package etp1;

import java.io.File;
import java.util.Date;

public class MaxSizeRep {

    public void recherche(String chemin) {
        File f = new File(chemin);
        if (f.exists() && f.isDirectory()) {
            File plusgros = null;
            for (File subdossier : f.listFiles()) {
                if (subdossier.isDirectory()) {
                    if (plusgros == null) {
                        plusgros = subdossier;
                    }

                    if (subdossier.length() > plusgros.length()) {
                        plusgros = subdossier;
                    }
                }
            }
            if (plusgros != null) {
                System.out.println("Le dossier le plus volumineux est " + plusgros.getName() + " ayant pour taille " + plusgros.length() + " octets");
            }
        } else {
            System.out.println("Erreur : le dossier demandé n'existe pas ou est invalide");
        }
    }

    public static void main(String[] args) {
        new MaxSizeRep().recherche("/Users/thomas/Dev");
    }
}
