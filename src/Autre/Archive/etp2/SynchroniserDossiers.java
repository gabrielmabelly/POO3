package etp2;

import java.io.*;
import java.nio.file.Files;

public class SynchroniserDossiers {

    public static void ecriture(File fsource, File fdest) {
        FileInputStream fis = null;
        FileOutputStream fos = null;

        try  {
            fis = new FileInputStream(fsource);
            fos = new FileOutputStream(fdest);

            byte[] buffer = new byte[1024];
            int lengthRead;
            while ((lengthRead = fis.read(buffer)) > 0) {
                fos.write(buffer, 0, lengthRead);
                fos.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fis.close();
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void synchroDossier(File folder, File folder2, int criteria) {
        if (!folder.isDirectory() || !folder2.isDirectory()) {
            System.err.println("Un des deux fichiers ne sont pas des dossiers.");
            System.exit(1);
        }
        try {
            for (File currFile : folder.listFiles()) {
                if (currFile.isDirectory()) {
                    File sousDossier = new File(folder2 + File.separator + currFile.getName());
                    if (!sousDossier.exists()) {Files.createDirectory(sousDossier.toPath());}
                    synchroDossier(currFile, sousDossier, criteria);
                } else {
                    File fichierDossier2 = new File(folder2 + File.separator + currFile.getName());
                    if (fichierDossier2.exists()) {
                        switch (criteria) {
                            case 0:
                                if (currFile.lastModified() > fichierDossier2.lastModified()) {
                                    ecriture(currFile, fichierDossier2);
                                } else {
                                    ecriture(fichierDossier2, currFile);
                                }
                                break;
                            case 1:
                                if (currFile.length() > fichierDossier2.length()) {
                                    ecriture(currFile, fichierDossier2);
                                } else {
                                    ecriture(fichierDossier2, currFile);
                                }
                                break;
                            case 2:
                                ecriture(currFile, fichierDossier2);
                                break;
                            case 3:
                                ecriture(fichierDossier2, currFile);
                                break;
                            default:
                                System.err.println("Criteria inconnu");
                                System.exit(2);
                        }
                    } else {
                        ecriture(currFile, fichierDossier2);
                    }

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void syncDossier(File f1, File f2, int criteria) throws IOException {
        synchroDossier(f1, f2, criteria);
        synchroDossier(f2, f1, criteria);
    }

    public static void main(String[] args) throws IOException {
        SynchroniserDossiers.syncDossier(new File("testsync1"), new File("testsync2"), 3);
    }

}
