package Etape10.Exercice4;

import java.util.Scanner;

public class Minuteur extends Thread
{
    private int secondes;

    public Minuteur(int secondes)
    {
        this.secondes = secondes;
    }

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        Minuteur minuteur = new Minuteur(10);

        minuteur.start();

        while (minuteur.getState() != State.TERMINATED)
        {

            System.out.println("Appuyez sur une touche pour arrêter le minuteur.");
            scanner.nextLine();
            minuteur.interrupt();
        }
        System.out.println(minuteur.getState()); // Notre minuteur est bien arrêté

    }


    public void run()
    {
        boolean run = true;
        while (this.secondes >= 0 && run)
        {
            try
            {
                Thread.sleep(1000);
                System.out.println(this.secondes);
                this.secondes--;

            } catch (InterruptedException e) // On entre dans le bloc après que le main tente d'interrompre pendant un sleep
            {
                if (run == true) // Permet d'éviter de re rentrer dans le try catch, le this.interrupt() soulève un exception
                {
                    try
                    {
                        System.out.println("Le minuteur a été arrêté pendant 5s, appuyez sur une touche pour l'arrêter complètement.");
                        Thread.sleep(5000);


                    } catch (InterruptedException ex) // On entre dans le bloc quand le main tente d'interrompre pendant le sleep de 5s
                    {
                        run = false;
                        System.out.println("Le minuteur a été arrêté définivement car vous avez appuyé sur une touche.");
                        this.interrupt();
                    }
                }
            }


        }
        if (run)
        {
            System.out.println("BIP BIP BIP \n Le minuteur est terminé ! ");
        }
        this.interrupt();


    }


}
