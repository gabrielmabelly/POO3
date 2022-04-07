package Etape12.Exercice4;

import java.util.ArrayList;
import java.util.Arrays;

public class Loto
{
    public static void main(String[] args)
    {
        boolean gagneOverall = false;
        ArrayList<Integer> listeNuméroTirés = new ArrayList<>();


        Joueur joe = new Joueur(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)), "joe", listeNuméroTirés, gagneOverall);
        Joueur jack = new Joueur((new ArrayList<>(Arrays.asList(7, 8, 9, 10, 11, 12))), "jack", listeNuméroTirés, gagneOverall);
        Joueur william = new Joueur(new ArrayList<>(Arrays.asList(13, 14, 15, 16, 16, 17)), "william", listeNuméroTirés, gagneOverall);
        Joueur averell = new Joueur(new ArrayList<>(Arrays.asList(18, 19, 20, 21, 22, 23)), "averell", listeNuméroTirés, gagneOverall);

        Ma ma = new Ma(joe, jack, william, averell, listeNuméroTirés, gagneOverall);


        ma.start();

        joe.start();
        jack.start();
        william.start();
        averell.start();

        try {
            ma.join();
            System.out.println("Fin du loto ! Bravo au gagnant");
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        System.exit(0);
    }
}
