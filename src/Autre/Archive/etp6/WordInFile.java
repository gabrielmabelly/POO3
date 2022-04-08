package etp6;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class WordInFile {

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

    public static void main(String[] args) {
        if (wordInFile("oui", "test.txt")) {
            System.out.println("Le mot est présent dans le fichier");
        } else {
            System.out.println("Le mot n'est pas présent dans le fichier");
        }
    }
}
