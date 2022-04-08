package Etape3.Exercice1;

import java.io.*;
import java.net.ServerSocket;
import java.nio.file.Files;
import java.nio.file.Paths;

public class readWriteInteger2
{
    public static void main(String[] args) throws Exception
    {
        try
        {
            int[] chart = {12, -25, 4584789, -1, 17, 56};


            File file = Paths.get(args[0]).toFile();
            file.delete();
            file.createNewFile();

            FileOutputStream fileOutputStream = new FileOutputStream(file);
            FileInputStream fileInputStream = new FileInputStream(file);

            DataOutputStream dataOutputStream = new DataOutputStream(fileOutputStream);
            DataInputStream dataInputStream = new DataInputStream(fileInputStream);



            for (int i = 0; i < chart.length; i++)
            {
                dataOutputStream.writeInt(chart[i]);
                ; // écrit dans le fichier les entiers présents dans notre tableau
                System.out.println("Un entier a été écrit dans le fichier.");
            }
            System.out.println("##################################################################################################");
            while (dataInputStream.available() != 0)
            {
                System.out.println("Entier lu : " + dataInputStream.readInt()) ;
            }

        } catch (Exception e)
        {
            e.printStackTrace();
            System.out.println("Il y a un problème.");
        }
    }
}
