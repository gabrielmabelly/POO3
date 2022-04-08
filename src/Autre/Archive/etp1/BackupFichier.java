package etp1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class BackupFichier {

    public void backup(String cheminACopierStr, String cheminBackupStr) throws IOException {
        Path cheminACopier = Paths.get(cheminACopierStr);
        Path cheminBackup = Paths.get(cheminBackupStr);
        Path tempFolder = Path.of(cheminBackupStr + "/back/");

        if (Files.exists(cheminACopier) && Files.exists(cheminBackup)) {
            Files.copy(Paths.get(cheminACopierStr), Paths.get(tempFolder + "/" + cheminACopier.getFileName() + "-" +  System.currentTimeMillis()), StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Fichier copié");
        } else {
            if (!Files.exists(cheminACopier)){
                System.out.println("Fichier introuvable");
            } else
            if (!Files.exists(cheminBackup)){
                Files.createDirectories(tempFolder);
                Files.copy(Paths.get(cheminACopierStr), Paths.get(tempFolder + "/" + cheminACopier.getFileName() + "-" +  System.currentTimeMillis()), StandardCopyOption.REPLACE_EXISTING);
                System.out.println("Dossier créé, fichier copié");
            }

        }
    }

    public static void main(String[] args) throws IOException {
        new BackupFichier().backup("exa.txt", "testation");
    }
}
