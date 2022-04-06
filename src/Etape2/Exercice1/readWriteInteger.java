package Etape2.Exercice1;

import java.io.*;
import java.nio.file.Paths;

public class readWriteInteger
{
    public static void main(String[] args) throws Exception
    {
        try
        {
            int[] chart = {12, -25, 4584789, -1, 17, 56};


            File sourceFile = Paths.get(args[0]).toFile();

            FileOutputStream outputStream = new FileOutputStream(sourceFile);
            FileInputStream inputStream = new FileInputStream(sourceFile);

            for (int i = 0; i < chart.length; i++)
            {
                outputStream.write(chart[i]); // écrit dans le fichier les entiers présents dans notre tableau
                System.out.println("Un entier a été écrit dans le fichier.");
            }
            System.out.println("##################################################################################################");
            while (inputStream.available() != 0)
            {
                System.out.println("Entier lu : " + inputStream.read());
            }

        } catch (Exception e)
        {
            System.out.println("Il y a un problème.");
        }
    }
}
