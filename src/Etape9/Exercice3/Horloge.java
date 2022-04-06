package Etape9.Exercice3;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Horloge extends Thread
{
    public void run()
    {
        MP3 mp3 = new MP3("C:\\Users\\Gabriel\\IdeaProjects\\ProgrammationOrientéeObjet3\\src\\Etape9\\Exercice3\\son.mp3");
        mp3.setDaemon(true);
        mp3.start();
        int i = 0;
        while (true)
        {
            i++;
            if (i % 10 == 0)
            {
                try
                {
                    Thread.sleep(100);
                } catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                System.out.println("[HORLOGE] Date : " + LocalDateTime.now());
            }
        }
    }


    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        Horloge horloge = new Horloge();


        horloge.setDaemon(true);
        horloge.start();
        System.out.println("Entrez ARRET sur entrée pour arrêter les deux fils d'exécution.");

        if (scanner.nextLine().equals("ARRET"))
            System.exit(-42);


    }


}
