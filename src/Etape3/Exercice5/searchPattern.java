package Etape3.Exercice5;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class searchPattern
{

    static ArrayList<Byte> arrayListByteS1;
    static ArrayList<Byte> arrayListByteS2;

    public static void main(String[] args) throws IOException
    {
        String s1 = "aa";
        String s2 = "bb";

        byte[] s1Bytes = s1.getBytes(StandardCharsets.UTF_8);
        byte[] s2Bytes = s2.getBytes(StandardCharsets.UTF_8);

        searchAndReplace(s1Bytes, s2Bytes, args[0]);

    }


    public static void searchAndReplace(byte[] pattern, byte[] substitute, String nomFile) throws IOException
    {
        File file = new File(nomFile);
        File file1 = new File(file.getParent() + "\\nvfichier.txt");

        file1.delete();
        file1.createNewFile();

        DataInputStream dataInputStream = new DataInputStream(new FileInputStream(file));
        DataOutputStream dataOutputStream = new DataOutputStream((new FileOutputStream(file1)));

        arrayListByteS1 = new ArrayList<>();
        arrayListByteS2 = new ArrayList<>();

        for (byte a : pattern)
        {
            arrayListByteS1.add(a);
        }
        for (byte a : substitute)
        {
            arrayListByteS2.add(a);
        }

        byte val1;
        byte val2 = 0;


        try
        {
            val1 = dataInputStream.readByte();
            while (val1 != -1)
            {
                if (val1 == arrayListByteS1.get(0))
                {


                    val2 = dataInputStream.readByte();
                    if (val2 == arrayListByteS1.get(1))
                    {
                        dataOutputStream.writeByte(arrayListByteS2.get(0)); // Si on détecte le pattern on écrit dans un nouveau flux les valeurs de substitution
                        dataOutputStream.writeByte(arrayListByteS2.get(1)); // Si on détecte le pattern on écrit dans un nouveau flux les valeurs de substitution
                    }
                }
                else
                {
                    dataOutputStream.writeByte(val1); // On réécrit les valeurs du fichier source

                }
                val1 = dataInputStream.readByte();
            }
        } catch (EOFException e)
        {

        }

    }

}
