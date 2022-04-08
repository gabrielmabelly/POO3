package etp11;

import java.io.File;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;

public class ChercherFichier implements Runnable {
    @Override
    public void run() {
        File file = new File("src/etp7");
        LocalDate lt = LocalDate.now();
        LocalDate avant = lt.minusDays(1);
        LocalDate apres = lt.plusDays(1);
        for (File f : file.listFiles()) {
            LocalDate dateFichier = Instant.ofEpochMilli(f.lastModified()).atZone(ZoneId.systemDefault()).toLocalDate();
            if (dateFichier.isAfter(avant) && dateFichier.isBefore(apres)) {
                System.out.println("Fichier : " + f.getName());
            }
        }
    }

    public static void main(String[] args) {
        ChercherFichier chercherFichier = new ChercherFichier();
        Thread sniffeur = new Thread(chercherFichier);
        sniffeur.start();
    }
}
