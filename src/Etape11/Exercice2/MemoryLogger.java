package Etape11.Exercice2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class MemoryLogger extends File implements Runnable
{


    public MemoryLogger(String pathname)
    {
        super(pathname);
        try
        {
            this.createNewFile();
        } catch (IOException e)
        {
            System.err.println("Entrez le bon chemin svp.");
        }
    }

    @Override
    public void run()
    {

        try (PrintWriter pw = new PrintWriter(this))
        {
            while (true)
            {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Mémoire consommée : ").append(Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory());
                pw.println(stringBuilder.toString());
            }


        } catch (FileNotFoundException e)
        {

        }


    }

    public static void main(String[] args)
    {
        Thread thread = new Thread(new MemoryLogger("G:\\Users\\Gabriel\\Documents\\Autre\\Cours MIASH\\1.txt"));
        thread.start();
        System.out.println("caca");
    }
}
