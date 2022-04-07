package Etape14.Exercice1;

public class LesBonsComptes extends Thread
{
    public static void main(String[] args) throws InterruptedException
    {


        Magot magot = new Magot();

        Dalton joe = new Dalton(8,magot);
        Dalton jack = new Dalton(8,magot);
        Dalton averell = new Dalton(8,magot);
        Dalton william = new Dalton(8,magot);


        joe.start();
        jack.start();
        averell.start();
        william.start();


        System.out.println(magot.afficheMagot().toString());


    }








}
