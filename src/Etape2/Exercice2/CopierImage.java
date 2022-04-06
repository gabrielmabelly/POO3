package Etape2.Exercice2;

import java.awt.*;
import java.io.*;
import java.nio.file.FileAlreadyExistsException;
import java.util.Scanner;

public class CopierImage
{
    static File sourceFile;
    static File destinationFile;
    static FileInputStream inputStream;
    static FileOutputStream outputStream;

    public CopierImage(String sourceFile, String destinationFile)
    {
        this.sourceFile = new File(sourceFile);
        this.destinationFile = new File(destinationFile);
    }


    public static void main(String[] args) throws IOException
    {
        CopierImage copierImage = new CopierImage(args[0], args[1]);

        if (copierImage.sourceFile.exists() && !copierImage.destinationFile.exists())
        {
            destinationFile.createNewFile();
            outputStream = new FileOutputStream(destinationFile);
            inputStream = new FileInputStream(sourceFile);

            while (inputStream.available() != 0)
            {
                outputStream.write(inputStream.read());
            }
            Desktop desktop = Desktop.getDesktop();
            desktop.open(destinationFile);
            System.out.println("Le fichier a été ouvert");

            destinationFile.delete();
            System.out.println("Suppresion du fichier effectuée.");


        } else

        {
            try
            {
                if (copierImage.destinationFile.exists() && !copierImage.sourceFile.exists())
                    throw new Exception("Le fichier destination existe et le fichier source n'existe pas.");
                if (!copierImage.sourceFile.exists())
                    throw new FileNotFoundException("Le fichier source n'a pas été trouvé.");
                if (copierImage.destinationFile.exists())
                    throw new FileAlreadyExistsException("Le fichier destination existe déjà.");
            } catch (Exception e)
            {
                e.printStackTrace();
                System.out.println(e.getMessage());
            }


        }
    }


}
