package Etape1bis.Exercice1;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;

public class BackupFile {
    public static void main(String[] args) throws IOException {

        long currentTimeMillis = System.currentTimeMillis();
        LocalDate localDate = LocalDate.now();

        Path fileToBackup = Paths.get(args[0]);
        System.out.println(fileToBackup.toString()); // Affiche le chemin entré en argument

        Path pathBackupFolder = Paths.get(".\\src\\Etape1bis\\Backup\\");
        if (!Files.exists(pathBackupFolder)) {
            Files.createDirectories(pathBackupFolder); // Création du dossier backup s'il n'existe pas déjà
        }
        System.out.println(pathBackupFolder.toAbsolutePath());

        Path pathFileToBackup = Paths.get(pathBackupFolder.toAbsolutePath() + "\\" + fileToBackup.getFileName() + "_" + localDate + "_" + currentTimeMillis + ".backup");
        System.out.println(pathFileToBackup.toAbsolutePath().toString()); // Chemin fichier sauvegardé
        Files.copy(fileToBackup, pathFileToBackup);
        System.out.println("Backup finished !");

    }

}







