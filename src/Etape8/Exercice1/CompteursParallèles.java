package Etape8.Exercice1;

public class CompteursParallèles extends Thread
{
    String name;
    public CompteursParallèles(String nom)
    {
        this.name = nom;
    }

    public void run()
    {
        int i = 0;
        while (i < 100)
        {
            System.out.println(this.name + " : i = " + i);
            i++;
        }
    }


    public static void main(String[] args)
    {
        CompteursParallèles chronos = new CompteursParallèles("Chronos");
        CompteursParallèles kairos = new CompteursParallèles("Kairos");

        chronos.start();
        kairos.start();

    }


}
