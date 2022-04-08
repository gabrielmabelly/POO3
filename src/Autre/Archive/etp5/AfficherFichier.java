package etp5;

import java.io.*;

public class AfficherFichier {

    public void afficherFichier(String nomfichier) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(nomfichier));
            int c;
            while ((c =  br.read()) != -1) {
                System.out.print((char) c);
            }
            br.close();
        } catch (FileNotFoundException e) {
            System.err.println("Fichier introuvable");
            System.exit(1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new AfficherFichier().afficherFichier("testfichier.txt");
    }
}
