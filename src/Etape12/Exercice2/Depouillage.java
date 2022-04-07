package Etape12.Exercice2;

public class Depouillage
{

    public static void main(String[] args)
    {
        Candidat duke = new Candidat("duke", 0);
        Candidat bugee = new Candidat("bugee", 0);

        Candidat[]  secondTour = new Candidat[2];

        secondTour[0] = duke;
        secondTour[1] = bugee;

        Urne urne = new Urne();
        Urne urne1 = new Urne();

        Assesseurs jo = new Assesseurs(secondTour, urne);
        Assesseurs donald = new Assesseurs(secondTour, urne1);

        jo.start();
        donald.start();

        try {


            jo.join();
            donald.join();
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }

        System.out.println("Score" + duke + bugee);


    }


}
