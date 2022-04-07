package Etape13.Exercice1;


public class Starter extends Thread
{
    @Override
    public void run()
    {
        for (int i = 5; i >= 0; i--)
        {
            try
            {
                Thread.sleep(1000);
                System.out.println("Début de la course dans : " + i + "secondes.");
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }


        }
    }
}
