package Etape4.Exercice3;

import Etape4.Exercice1.Mobile;

import java.io.*;
import java.util.ArrayList;

public class Main
{
    public static void main(String[] args) throws IOException, ClassNotFoundException
    {


/*
        Famille familleGen0 = new Famille("nom0", "prénompère0", "prénomMère0",
                "nomJeuneFilleMère0", new ArrayList<>());
        Famille familleGen1n1 = new Famille("nom1n1", "prénompère1n1", "prénomMère1n1",
                "nomJeuneFilleMère1n1", new ArrayList<>());
        Famille familleGen1n2 = new Famille("nom1n2", "prénompère1n2", null,
                null, null);
        Famille familleGen2n1 = new Famille("nom2n1", "prénompère2n1", "prénomMère2n1",
                "nomJeuneFilleMère2n1", new ArrayList<>());
        Famille familleGen2n2 = new Famille("nom2n2", "prénompère2n2", null,
                null, null);
        Famille familleGen3n1 = new Famille("nom3n1", "prénompère3n1", "prénomMère3n1",
                "nomJeuneFilleMère3n1", new ArrayList<>());
        Famille familleGen3n2 = new Famille("nom3n2", "prénompère3n2", "prénomMère3n2",
                "nomJeuneFilleMère3n2", new ArrayList<>());
        Famille familleGen4n1 = new Famille("nom4n1", "prénompère4n1", "prénomMère4n1",
                "nomJeuneFilleMère4n1", new ArrayList<>());

        familleGen0.familles.add(familleGen1n1);
        familleGen0.familles.add(familleGen1n2);

        familleGen1n1.familles.add(familleGen2n1);
        familleGen1n1.familles.add(familleGen2n2);

        familleGen2n1.familles.add(familleGen3n1);
        familleGen2n1.familles.add(familleGen3n2);
        familleGen3n1.familles.add(familleGen4n1);
        save("C:\\Users\\Gabriel\\IdeaProjects\\ProgrammationOrientéeObjet3\\src\\Etape4\\Exercice3\\test.txt", familleGen0);

*/


        Famille familleChargee = load("C:\\Users\\Gabriel\\IdeaProjects\\ProgrammationOrientéeObjet3\\src\\Etape4\\Exercice3\\test.txt");
        System.out.println(familleChargee);


    }


    public static void save(String nomFichier, Famille famille) throws IOException
    {
        {
            FileOutputStream fos = new FileOutputStream(nomFichier);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(famille);
            oos.flush();
            oos.close();
        }
    }

    public static Famille load(String nomFichier) throws IOException, ClassNotFoundException
    {

        FileInputStream fileInputStream = new FileInputStream(nomFichier);
        ObjectInputStream oos = new ObjectInputStream(fileInputStream);
        Famille famille = (Famille) (oos.readObject());
        oos.close();

        return famille;
    }



}
