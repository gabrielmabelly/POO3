package Etape9.Exercice1;


import java.util.Scanner;

public class StopWatch extends Thread
{
    @Override
    public void run()
    {
        int i = 0;
        while (true)
        {

            if (this.isInterrupted() && (i % 10) == 0)
            {

                System.out.println("[THREAD] Bravo le thread a été interrompu ! " + i);
                break;
            }
            System.out.println("Compteur : " + i);
            i++;


        }
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        StopWatch stopwatch = new StopWatch();

        stopwatch.start();

        while (true)
        {
            System.out.println("Appuyez sur une touche");
            System.out.println(sc.nextLine());
            stopwatch.interrupt();
            if (stopwatch.isInterrupted())
            {
                System.out.println("[MAIN] Le thread a été interrompu");
                break;
            }

        }


    }


}



