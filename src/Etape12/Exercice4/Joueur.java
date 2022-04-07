package Etape12.Exercice4;

import java.util.ArrayList;

public class Joueur extends Thread
{

    ArrayList<Integer> listNumerosMa;
    ArrayList<Integer> listNumeros;
    String nom;
    boolean aGagné;
    boolean gagneOverall;

    public Joueur(ArrayList<Integer> listNumeros, String nom, ArrayList<Integer> listNuméroMa, boolean gagneOverall)
    {
        this.listNumerosMa = listNuméroMa;
        this.listNumeros = listNumeros;
        this.nom = nom;
        this.aGagné = false;
        this.gagneOverall = gagneOverall;
    }


    @Override
    public void run()
    {
        while (!aGagné)
        {
            if (listNumerosMa.containsAll(listNumeros))
            {
                aGagné = true; // Si la liste de ma contient TOUS les numéros du joueur alors aGagné passe à true ==> Sera utilisé par Ma pour déterminer le vainqueur
            }
        }
    }

}

