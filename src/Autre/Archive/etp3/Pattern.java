package etp3;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class Pattern {

    public static void searchAndReplace(int[] motif, int[] subst, String nomFile) {
        if (motif.length != subst.length) {
            System.err.println("Le motif et le chaine de remplacement ne font pas la même taille");
            System.exit(1);
        }

        try {
            DataInputStream fis = new DataInputStream(new FileInputStream(nomFile));
            ArrayList<Integer> bytes = new ArrayList<>();
            int data = fis.read();
            while (data != -1) {
                bytes.add(data);
                data = fis.read();
            }
            int size = bytes.size();
            boolean found = true;
            for (int i = 0; i < size - motif.length +1 ; ++i) {
                found = true;
                for (int j = 0; j < motif.length; ++j) {
                    if (bytes.get(i+j) != motif[j]) {
                        found = false;
                        break;
                    }
                }
                if (found) {
                    for (int k = 0; k < motif.length; k++) {
                        bytes.set(i + k, subst[k]);
                    }
                    i += (motif.length - 1);
                }
            }

            DataOutputStream dos = new DataOutputStream(new FileOutputStream(nomFile));
            for (Integer aByte : bytes) {
                dos.write(aByte);
            }
            dos.close();
            fis.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void testEcritureFichier(String nom, String texte) {

        try {
            DataOutputStream dos = new DataOutputStream(new FileOutputStream(nom));
            byte[] strbytes = texte.getBytes(StandardCharsets.UTF_8);
            for (byte strbyte : strbytes) {
                dos.write(strbyte);
            }
            dos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws IOException {
        int[] search = new int[]{'d', 'e', 'f'};
        int[] replacement = new int[]{'a', 'b', 'c'};

        // création d'un fichier binaire pour tester
        // testEcritureFichier("test.txt", "abcdefabddefdedabfdedef");


        searchAndReplace(search, replacement, "test.txt");
        // entrée   : abcdefabddefdedabfdedef
        // résultat : abcabcabdabcdedabfdeabc

    }

}