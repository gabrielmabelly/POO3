package Etape10.Exercice3;

import java.util.Scanner;

public class ChronoPause extends Thread
{

    public static void main(String[] args) throws InterruptedException
    {
        Scanner sc = new Scanner(System.in);

        ChronoPause chronov2 = new ChronoPause();
        chronov2.setName("Chronomètre au dixième");
        chronov2.start();



                System.out.println("Appuyez sur une touche puis entrée pour interrompre le chronomètre.");
                sc.nextLine();
                chronov2.interrupt();




    }


    @Override
    public void run()
    {

        long cumul = 0;
        long reste;
        long[] temps = new long[]{0, 0, 0, 0}; // hh / mm / ss / dd

        while (true)
        {

            System.out.println("Temps écoulé : [" + temps[0] + ":" + temps[1] + ":" + temps[2] + ":" + temps[3] + "]");

            try
            {
                Thread.sleep(100);
                cumul += 1;
                temps[0] = cumul / 360000;
                reste = cumul % 360000;
                temps[1] = reste / 6000;
                reste = reste % 6000;
                temps[2] = reste / 60;
                temps[3] = reste % 60;

            } catch (InterruptedException e) // On entre dans le bloc catch quand le main tente d'interrompre le fil d'éxécution pendant sleep
            {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Appuyez sur une touche pour relancer le chronomètre");
                scanner.nextLine();
                this.isInterrupted();
            }


        }

    }
}
