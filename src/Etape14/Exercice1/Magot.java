package Etape14.Exercice1;

public class Magot

{
    Integer magot;

    public Magot()
    {
        this.magot = 0;
    }

    public synchronized Integer afficheMagot()
    {return this.magot;    }


}
