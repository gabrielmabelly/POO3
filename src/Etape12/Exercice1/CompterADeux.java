package Etape12.Exercice1;

public class CompterADeux extends Thread
{
    static cpt cpt;

    public CompterADeux(cpt cpt)
    {
        CompterADeux.cpt = cpt;
    }

    @Override
    public void run()
    {


        try
        {
            while (cpt.cpt < 10000)
        {
            System.out.println(Thread.currentThread().getName() + " " + cpt.cpt);
            cpt.cpt++;

            Thread.sleep(1);

        }
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }

    }

    public static void main(String[] args)
    {
        cpt cpt = new cpt(0);

        Thread cpt1 = new CompterADeux(cpt);
        Thread cpt2 = new CompterADeux(cpt);

        cpt1.start();
        cpt2.start();

    }

    static class cpt extends Thread
    {
        public int cpt;

        public cpt(int cpt)
        {
            this.cpt = cpt;
        }
    }

}
