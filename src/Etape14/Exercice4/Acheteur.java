package Etape14.Exercice4;

import java.util.Random;

public class Acheteur extends Thread
{
    Enchère enchère;
    String name;
    Random random;


    public Acheteur(Enchère enchère, String name)
    {
        this.random = new Random();
        this.enchère = enchère;
        this.name = name;
    }



    @Override
    public void run()
    {
        for (int i = 0; i < 5; i++) // 5 propositions max
        {
            synchronized (enchère) // On bloque l'accès à enchère pour éviter que l'accès se fasse correctement.
            {
                enchère.derniereEnchère = generePrix(this.enchère.derniereEnchère);
                System.out.println("[" + Thread.currentThread().getName() + "]" + " (" + this.name+  ") vient de faire une enchère de : " + enchère.derniereEnchère);
                enchère.dernierAcheteur = this;
                enchère.notifyAll();
            }
            try
            {
                Thread.sleep(random.nextInt(5000)) ; // Histoire de laisser aux autres le temps d'enchérir
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }

    public synchronized int generePrix(int i)
    {

        return random.nextInt(4) + 1 + this.enchère.derniereEnchère;

    }


}
