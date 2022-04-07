package Etape14.Exercice4;

import java.util.Random;

public class Enchère extends Thread
{
    Integer miseAPrix;
    Integer derniereEnchère;
    Acheteur dernierAcheteur; // On aura le gagnant à la fin de l'enchère

    public Enchère(Integer miseAPrix)
    {
        this.miseAPrix = miseAPrix;
        this.derniereEnchère = miseAPrix;
    }


    @Override
    public void run()
    {
        try
        {
            Thread.sleep(new Random().nextInt(10000));
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        this.miseAPrix = (new Random().nextInt(1000));
        this.derniereEnchère = this.miseAPrix; // Pour que l'on puisse réutiliser la variable via les acheteurs même au début de l'enchère
    }
}
