package etp5;

import java.io.*;

public class GenereSite {

    public static void genererSite(String root) {
        File froot = new File(root);
        if (!froot.isDirectory()) {
            System.err.println("Le lien ne pointe pas sur un dossier");
            System.exit(1);
        }

        File fconfig = new File(root, "config.txt");
        if (!fconfig.isFile()) {
            System.err.println("Le fichier config.txt n'existe pas");
            System.exit(2);
        }

        try {
            BufferedReader bri = new BufferedReader(new FileReader(fconfig));
            BufferedReader briprod;
            BufferedWriter bro;

            String entete = bri.readLine();
            String baspage = bri.readLine();

            if (entete == null || baspage == null) {
                System.err.println("Mauvaise configuration");
                System.exit(3);
            }

            File fentete = new File(root, entete);
            File fbaspage = new File(root, baspage);

            if (!fentete.exists() || !fbaspage.exists()) {
                System.err.println("L'entête ou le bas de page n'existe pas");
                System.exit(4);
            }

            BufferedReader briEntetePied = new BufferedReader(new FileReader(fentete));
            String contenuEntete = "";
            String contenuBasPage = "";

            String line = briEntetePied.readLine();
            while (line != null) {
                contenuEntete += line + '\n';
                line = briEntetePied.readLine();
            }

            briEntetePied = new BufferedReader(new FileReader(fbaspage));
            line = briEntetePied.readLine();
            while (line != null) {
                contenuBasPage += line + '\n';
                line = briEntetePied.readLine();
            }

            briEntetePied.close();

            File fprod = new File(root, "prod");
            for (File f : fprod.listFiles()) {
                f.delete();
            }
            fprod.delete();
            fprod.mkdirs();

            String contenulien = bri.readLine();
            while (contenulien != null) {
                briprod = new BufferedReader(new FileReader(new File(froot.getPath(), contenulien)));
                bro = new BufferedWriter(new FileWriter(new File(fprod.getPath(), contenulien.substring(0, contenulien.lastIndexOf('.')) + ".htm")));

                bro.write(contenuEntete);

                line = briprod.readLine();
                while (line != null) {
                    bro.write(line + '\n');
                    line = briprod.readLine();
                }

                bro.write(contenuBasPage);

                briprod.close();
                bro.close();
                contenulien = bri.readLine();
            }

            System.out.println("Site généré");

            bri.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        genererSite("site");
    }
}
