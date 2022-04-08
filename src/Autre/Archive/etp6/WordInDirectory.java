package etp6;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class WordInDirectory {

    public static boolean wordInFile(String motATrouver, String nomfichier) {
        File file = new File(nomfichier);
        if (!file.exists()) {
            System.err.println("Le fichier n'existe pas");
            System.exit(1);
        }

        try {
            if (!(Files.probeContentType(file.toPath()).equals("text/plain"))) {
                System.err.println("Le fichier n'est pas un fichier texte");
                System.exit(2);
            }

            List<String> contenu = Files.readAllLines(file.toPath());
            for (String ligne : contenu) {
                String[] mots = ligne.split(" ");
                for (String mot : mots) {
                    if (mot.equals(motATrouver)) {
                        return true;
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;

    }

    private static ArrayList<File> getRepertoire(File rep) {
        File[] files = rep.listFiles();
        ArrayList<File> contenuRep = new ArrayList<File>();
        int i = 0;

        if (files == null) {
            System.err.println("Dossier vide");
            System.exit(1);
        }

        for (File file : files) {
            if (file.isFile()) {
                contenuRep.add(file);
            } else {
                contenuRep.addAll(getRepertoire(file));
            }
        }

        return contenuRep;
    }

    public static void wordInDirectory(String word, String dir) {
        ArrayList<File> fichiers = getRepertoire(new File(dir));
        for (File fichier : fichiers) {
            if (wordInFile(word, fichier.getPath())) {
                System.out.println("Le mot se trouve dans le fichier " + fichier.getPath());
            }
        }
    }

    public static void main(String[] args) {
        wordInDirectory("oui", "test/");
    }
}
