package Etape5.Exercice3;

import java.io.*;

public class Redirections
{

    public static void donnees(InputStream is, OutputStream os)
    {
        try
        {

            BufferedReader bri = new BufferedReader(new InputStreamReader(is));
            BufferedWriter bro = new BufferedWriter(new OutputStreamWriter(os));

            String line = bri.readLine();
            if (line != null)
            {
                while (!line.equals("fin"))
                {
                    bro.write(line + '\n');
                    bro.flush();
                    line = bri.readLine();
                }
                ;
                bro.close();
                bri.close();
            }
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static void main(String[] args)
    {
        // user input et console
        // donnees(System.in, System.err);


        // fichiers
        File fi = new File("user.txt");
        File fo = new File("résultat.txt");

        if (!fi.isFile() || !fo.isFile())
        {
            System.err.println("Un des fichiers est introuvable");
            System.exit(1);
        }

        try
        {
            donnees(new FileInputStream(fi), new FileOutputStream(fo));
        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
    }
}
