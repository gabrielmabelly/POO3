package etp1;

import java.io.File;
import java.util.Date;

public class InformationFichier {

    public void avoirInformations(String chemin) {
        File f = new File(chemin);
        if (f.exists()) {
            System.out.print("Le chemin ");

            if (f.isAbsolute()) {
                System.out.print("absolu");
            } else {
                System.out.print("relatif");
            }

            System.out.print(" pointe sur un ");

            if (f.isDirectory()) {
                System.out.println("dossier.");
                System.out.print("Ce dossier contient les fichiers suivants : ");
                for (String name : f.list()) {
                    System.out.print(name + ", ");
                }
                System.out.println();
            } else if (f.isFile()) {
                System.out.println("fichier.");
                System.out.println("Ce fichier a pour taille " + f.length() + " octets");
            }
            System.out.println("Ses permissions sont : " +
                    (f.canRead() ? "r" : "-") +
                    (f.canWrite() ? "w" : "-") +
                    (f.canExecute() ? "x" : "-")
                    );

            Date date= new Date(f.lastModified());
            System.out.println("Il a été modifié la dernière fois le " + date);

            if (!chemin.equals(f.getAbsolutePath())) {
                System.out.println("Son chemin absolu est " + f.getAbsolutePath());
            }
        } else {
            System.out.println("Erreur : le fichier demandé n'existe pas");
        }
    }

    public static void main(String[] args) {
        new InformationFichier().avoirInformations("/Users/thomas/Dev");
    }
}
