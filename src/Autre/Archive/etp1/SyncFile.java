package etp1;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class SyncFile {

    public void syncFile(Path p1, Path p2, int criteria) throws IOException {
        if (Files.isRegularFile(p1) && Files.isRegularFile(p2)) {
            if (p1.getFileName().equals(p2.getFileName())) {
                if (criteria == 0) {
                    if (Files.getLastModifiedTime(p1).toMillis() > Files.getLastModifiedTime(p2).toMillis()) {
                        Files.copy(p1, p2, StandardCopyOption.REPLACE_EXISTING);
                        System.out.println("p1 copié dans p2");
                    } else if (Files.getLastModifiedTime(p1).toMillis() < Files.getLastModifiedTime(p2).toMillis()) {
                        Files.copy(p2, p1, StandardCopyOption.REPLACE_EXISTING);
                        System.out.println("p2 copié dans p1");
                    }
                } else if (criteria == 1) {
                    if (Files.size(p1) > Files.size(p2)) {
                        Files.copy(p1, p2, StandardCopyOption.REPLACE_EXISTING);
                        System.out.println("p1 copié dans p2");
                    } else if (Files.size(p1) < Files.size(p2)) {
                        Files.copy(p2, p1, StandardCopyOption.REPLACE_EXISTING);
                        System.out.println("p2 copié dans p1");
                    }
                } else if (criteria == 2) {
                    Files.copy(p1, p2, StandardCopyOption.REPLACE_EXISTING);
                    System.out.println("p1 copié dans p2");

                } else if (criteria == 3) {
                    Files.copy(p2, p1, StandardCopyOption.REPLACE_EXISTING);
                    System.out.println("p2 copié dans p1");

                } else {
                    System.out.println("Erreur, criteria non pris en charge.");
                }
            } else {
                Files.copy(p1, Paths.get(p2.getParent() + File.separator + p1.getFileName()), StandardCopyOption.REPLACE_EXISTING);
                //Files.copy(p2, Paths.get(p1.getParent() + File.separator + p2.getFileName()), StandardCopyOption.REPLACE_EXISTING);
                System.out.println("Harmonisation des fichiers");
            }
        } else {
            System.out.println("Erreur, les deux liens ne pointent pas sur des fichiers.");
        }
    }

    public static void main(String[] args) throws IOException {
        new SyncFile().syncFile(Path.of("testsyncfile/dir1/file.txt"), Path.of( "testsyncfile/dir2/file.txt"), 0);
    }
}
