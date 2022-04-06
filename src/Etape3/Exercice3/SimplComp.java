package Etape3.Exercice3;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class SimplComp
{

    public static void main(String[] args) throws IOException
    {

        File source = new File(args[0]);
        FileInputStream fileInputStream = null;
        if (source.isDirectory())
        {
            System.out.println(source.getParent() + "\\" + source.getName() + ".zip");
            FileOutputStream fileOutputStream = new FileOutputStream(source.getParent() + "\\" + source.getName() + ".zip");

            ZipOutputStream zipOutputStream = new ZipOutputStream(fileOutputStream);
            ZipEntry zipEntry;
            byte[] data = new byte[4096];

            for (File file : source.listFiles())
            {
                if (!file.isDirectory())
                {
                    fileInputStream = new FileInputStream(file);
                    zipEntry = new ZipEntry(file.getName());
                    zipOutputStream.putNextEntry(zipEntry);
                    int count;
                    while ((count = fileInputStream.read(data, 0, 4096)) != -1)
                    {
                        zipOutputStream.write(data, 0, count);
                    }
                    zipOutputStream.closeEntry();
                }




            }
            zipOutputStream.close();
            fileInputStream.close();
            fileOutputStream.close();



        } else
        {
            System.out.println("Donnez un dossier en paramètre pitié.");
        }

    }


}
