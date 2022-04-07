package Etape12.Exercice2;

public class Assesseurs extends Thread
{
    volatile Candidat[] secondTour;
    volatile Urne urne;

    public Assesseurs(Candidat[] secondTour, Urne urne)
    {
        this.secondTour = secondTour;
        this.urne = urne;
    }

    public void run()
    {
        int i = 0;

        while (i<100000)
        {
            secondTour[urne.genereBulletin()].votes++;
            i++;
        }

    }

}
