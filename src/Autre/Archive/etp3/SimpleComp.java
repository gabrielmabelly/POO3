package etp3;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class SimpleComp {

    public static void zip(String dossierpath) {
        try {
            int buffer = 2048;
            File dossier = new File(dossierpath);
            if (!dossier.isDirectory()) {
                System.err.println("Le fichier passé n'est pas un dossier.");
                System.exit(1);
            }

            FileOutputStream fos = new FileOutputStream(dossier.getName() + ".zip");
            ZipOutputStream zos = new ZipOutputStream(fos);
            byte[] data = new byte[buffer];

            for (File file : dossier.listFiles()) {
                if (file.isFile()) {
                    FileInputStream fis = new FileInputStream(file.getPath());
                    zos.putNextEntry(new ZipEntry(file.getPath()));

                    int count;
                    while ((count = fis.read(data, 0, buffer)) != -1) {
                        zos.write(data, 0, count);
                    }

                    zos.closeEntry();
                    fis.close();
                }
            }
            zos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        zip("testarchive");
    }
}
