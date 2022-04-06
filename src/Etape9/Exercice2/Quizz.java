package Etape9.Exercice2;

import java.util.Scanner;

public class Quizz extends Thread
{
    private String question;
    private String answer;

    public Quizz()
    {
        this.question = "1 + 1 = ?";
        this.answer = "2";
    }

    public void run()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println(this.question);

        if (this.answer.equals(scanner.nextLine()))
        {
            System.out.println("Réponse correcte.");
        } else
            System.out.println("Incorrect");
        this.interrupt();


    }


    public static void main(String[] args)
    {
        Quizz quizz = new Quizz();


        quizz.start();
        long debut = System.currentTimeMillis();

        while (System.currentTimeMillis() < debut * 1000 * 10)
        {
            if (!quizz.isAlive())
            {
                System.out.println("La réponse était : " + quizz.answer);
                break;
            }

        }

        System.out.println("Fin du programme.");
        System.exit(0);

    }


}



