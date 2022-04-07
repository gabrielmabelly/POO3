package Etape12.Exercice4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

public class Ma extends Thread
{
    public boolean joueurGagne;
    public ArrayList<Integer> listeNuméroTirés;
    Random random;
    Joueur j1;
    Joueur j2;
    Joueur j3;
    Joueur j4;
    boolean gagneOverall;

    public Ma(Joueur j1, Joueur j2, Joueur j3, Joueur j4, ArrayList listeNuméroTirés, boolean gagneOverall)
    {
        this.j1 = j1;
        this.j2 = j2;
        this.j3 = j3;
        this.j4 = j4;

        this.listeNuméroTirés = listeNuméroTirés;
        this.random = new Random();
        this.joueurGagne = false;
        this.gagneOverall = gagneOverall;
    }

    @Override
    public void run()
    {
        for (int i = 5; i >= 0; i--)
        {
            try
            {
                Thread.sleep(1000);
                System.out.println("Début du loto dans : " + i); // Compte à rebour comme demandé
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
        while (!j1.aGagné && !j2.aGagné && !j3.aGagné && !j4.aGagné)
        {
            Collections.sort(listeNuméroTirés); // Tri de la liste (plus lisible)
            System.out.println(this.listeNuméroTirés); // On affiche les tirages de Ma
            try
            {
                Thread.sleep(100); // Petit sleep histoire de voir l'éxécution du programme
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }


            int temp = (random.nextInt(98) + 1); // Pas de 0 et pas de 100 non plus
            if (!listeNuméroTirés.contains(temp)) // Au loto on ne peut tirer les numéros qu'une fois
            {
                listeNuméroTirés.add(temp);
            }


        }
        if (j1.aGagné)
        {
            gagneOverall = true;
            System.out.println(j1.nom + "(" + Thread.currentThread().getName() + ")" + " a gagné");
            this.interrupt();
        }
        if (j2.aGagné)
        {
            gagneOverall = true;
            System.out.println(j2.nom + "(" + Thread.currentThread().getName() + ")" + " a gagné");
            this.interrupt();
        }
        if (j3.aGagné)
        {
            gagneOverall = true;
            System.out.println(j3.nom + "(" + Thread.currentThread().getName() + ")" + " a gagné");
            this.interrupt();
        }
        if (j4.aGagné)
        {
            gagneOverall = true;
            System.out.println(j4.nom + "(" + Thread.currentThread().getName() + ")" + " a gagné");
            this.interrupt();
        }

    }
}
