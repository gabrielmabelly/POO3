package Etape1;

import java.io.File;
import java.io.IOException;

public class DeplacerFichier
{

    public static void main(String[] args)
    {

        File f = new File(args[0]);
        File destination = new File(args[1]);
        System.out.println(f.exists());
        System.out.println(destination.exists());


        if (f.exists())
        {
            System.out.println("Résultat du déplacement : " + f.renameTo(destination));

        } else
            System.out.println("Le fichier n'existe pas");

    }


}
