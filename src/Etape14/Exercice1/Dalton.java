package Etape14.Exercice1;

public class Dalton extends Thread implements Runnable
{
    Integer nombreBillets;
    Magot magot;

    public Dalton(Integer nombreBillets, Magot magot)
    {
        this.nombreBillets = nombreBillets;
        this.magot = magot;
    }


    @Override
    public void run()
    {
        synchronized (magot)
        {
            while(nombreBillets >= 0)
            {
                System.out.println(Thread.currentThread().getName() + " nombre de billets  : " + this.nombreBillets);

                magot.magot++;
                nombreBillets--;
            }
        }


    }
}
