package Etape4.Exercice1;

import com.sun.org.apache.bcel.internal.generic.INSTANCEOF;

import java.io.*;

public class Main
{
    public static void main(String[] args) throws IOException, ClassNotFoundException
    {
        Mobile mobile = new Mobile("Apple", "Iphone 13", 1, 8,
                128, true, 1000.00);
        Mobile mobile1 = new Mobile("Apple", "Iphone 12", 1, 8,
                128, true, 1000.00);
        Mobile mobile2 = new Mobile("Apple", "Iphone 11", 1, 8,
                128, true, 1000.00);


        save(".\\src\\Etape4\\test", mobile);
        save(".\\src\\Etape4\\test1", mobile1);
        save(".\\src\\Etape4\\test2", mobile2);

        Mobile loadMobile = load(".\\src\\Etape4\\test");
        Mobile loadMobile1 = load(".\\src\\Etape4\\test1");
        Mobile loadMobile2 = load(".\\src\\Etape4\\test2");
        System.out.println(loadMobile + "\n" + loadMobile1 + "\n" + loadMobile2);

    }

    public static void save(String nomFichier, Mobile mobile) throws IOException
    {
        {
            FileOutputStream fos = new FileOutputStream(nomFichier);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(mobile);
            oos.flush();
            oos.close();
        }
    }

    public static Mobile load(String nomFichier) throws IOException, ClassNotFoundException
    {

        FileInputStream fileInputStream = new FileInputStream(nomFichier);
        ObjectInputStream oos = new ObjectInputStream(fileInputStream);
        Mobile mobile = (Mobile) (oos.readObject());
        oos.close();

        return mobile;
    }

}
