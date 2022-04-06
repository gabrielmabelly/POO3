package Etape3.Exercice2;

import java.io.*;

public class CompareBinaryCopy
{
    File sourceFile;
    File targetFile;
    File targetFolder;
    FileInputStream fileInputStream;
    FileOutputStream fileOutputStream;

    public CompareBinaryCopy(String pathSource, String pathTarget) throws FileNotFoundException
    {
        this.sourceFile = new File(pathSource);
        this.targetFile = new File(pathTarget);
        this.targetFolder = new File(targetFile.getParent());


        if (!sourceFile.exists() || !sourceFile.isFile())
        {
            System.err.println("Le fichier source n'existe pas.");
            System.exit(-1);
        }


        this.fileInputStream = new FileInputStream(this.sourceFile);
        this.fileOutputStream = new FileOutputStream(this.targetFile);


    }

    public long copyBytePerByte() throws IOException
    {
        FileInputStream inputStream = this.fileInputStream;
        FileOutputStream outputStream = this.fileOutputStream;
        long time = System.nanoTime();
        while (inputStream.available() != 0)
        {
            outputStream.write(inputStream.read());
        }

        time = System.nanoTime() - time;

        return time;

    }

    public long copy64Bytes() throws IOException
    {
        FileInputStream inputStream = this.fileInputStream;
        FileOutputStream outputStream = this.fileOutputStream;
        byte[] temp = new byte[64];

        long time = System.nanoTime();
        while (inputStream.available() != 0)
        {
            outputStream.write(inputStream.read(temp));
        }
        time = System.nanoTime() - time;


        return time;

    }

    public long copyAll() throws IOException
    {
        FileInputStream inputStream = this.fileInputStream;
        FileOutputStream outputStream = this.fileOutputStream;
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream,100);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream,100);


        long time = System.nanoTime();

        while (bufferedInputStream.available() != 0)
        {

            bufferedOutputStream.write((bufferedInputStream.read()));
        }
        time = System.nanoTime() - time;

        return time;

    }


    public static void main(String[] args) throws IOException
    {

        CompareBinaryCopy compareBinaryCopy = new CompareBinaryCopy(args[0], args[1]);
        System.out.println("Temps octet par octet : " + compareBinaryCopy.copyBytePerByte());
        System.out.println("Temps 64 octets : " + compareBinaryCopy.copy64Bytes());
        System.out.println("Temps all : " + compareBinaryCopy.copyAll());


    }


}
