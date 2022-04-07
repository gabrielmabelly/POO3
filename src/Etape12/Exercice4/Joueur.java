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
        System.out.println(this.listNumeros);
        this.nom = nom;
        this.aGagné = false;
        this.gagneOverall = gagneOverall;
    }


    @Override
    public void run()
    {
        while (!aGagné)
        {

//            System.out.println("LISTE NUMERO" + Thread.currentThread().getName() + listNumeros);
//            System.out.println("LISTE NUMERO MA" + Thread.currentThread().getName() + listNumerosMa);


            if (listNumerosMa.containsAll(listNumeros))
            {


                System.out.println(Thread.currentThread().getName() + listNumerosMa + "MERDEEEEEEEEEEEEEEEEEEEEEEEEEEEEE");

                System.out.println(Thread.currentThread() + " " + listNumeros);
                aGagné = true;
            }

            if (this.gagneOverall)
            {
                this.interrupt();
            }

        }


    }

}

