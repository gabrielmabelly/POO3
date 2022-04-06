package Etape7.Exercice3;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;

public class DirView implements Serializable
{
    private ArrayList<File> fileArrayList;

    public DirView(String directory)
    {
        try {
            File rootFolder = new File(directory);
            this.fileArrayList = new ArrayList<>();
            for (File file : rootFolder.listFiles())
            {
                if (file.isFile())
                {
                    this.fileArrayList.add(file);
                }
            }
        } catch(Exception e)
        {
            System.out.println(e.getMessage());
        }



    }

    public void display()
    {
        try {
            if (fileArrayList.size() == 0)
            {
                System.out.println("Dossier vide");
            } else
            {
                for (int i = 0; i < this.fileArrayList.size(); i++)
                {
                    System.out.println("Fichier n°" + i + " - " + fileArrayList.get(i).getName());
                }
            }
        } catch (Exception e)
        {
            System.err.println("Chemin incorrect.");
            e.printStackTrace();
        }


    }

    public File returnFile(int i)
    {
        return this.fileArrayList.get(i);
    }
}
