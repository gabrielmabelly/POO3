package Etape11.Exercice4;

import Etape9.Exercice2.Quizz;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.*;

public class Etape11Exercice4
{
    public static void main(String[] args)
    {
        QuizzV2 quizzV2 = new QuizzV2();

        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Future<List<String>> listFuture = executorService.submit(quizzV2);

        try
        {
            System.out.println(listFuture.get(5, TimeUnit.SECONDS)); // Petit timeout bien carré
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        } catch (ExecutionException e)
        {
            e.printStackTrace();
        } catch (TimeoutException e) // Si l'utilisateur ne répond pas à temps on lui répond ça.
        {
            System.err.println("Il fallait être plus rapide, vous êtes pas très fort.");
        }
        System.exit(0);
    }


}

class QuizzV2 implements Callable<List<String>>
{

    private String question;
    private String answer;
    private List<String> rep;

    public QuizzV2()
    {
        this.question = "1 + 1 = ?";
        this.answer = "2";
        this.rep = new ArrayList<>();
    }

    public List<String> call()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println(this.question);

        if (this.answer.equals(scanner.nextLine()))
        {
            rep.add("Réponse correcte.");
        } else
            rep.add("Incorrect.");

        return rep;

    }


}