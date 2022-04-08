package etp5;

import java.io.*;

public class CreerFichier {

    public void creerFicher(String nomfichier) {
        File file = new File(nomfichier);
        if (file.exists()) {
            System.err.println("Le fichier existe déjà");
            System.exit(1);
        }
        try {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Saisir du texte : ");
            String line = br.readLine();

            OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(file));
            osw.write(line);

            osw.close();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new CreerFichier().creerFicher("monfichier.txt");
    }
}
