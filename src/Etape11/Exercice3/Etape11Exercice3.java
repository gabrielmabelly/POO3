package Etape11.Exercice3;

import Etape10.Exercice4.Minuteur;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Etape11Exercice3
{
    public static void main(String[] args)
    {


        Long debut = System.currentTimeMillis();
        Long t1;
        Long nb = 17113L;

        NombreComplexe nombreComplexe = new NombreComplexe(nb);

        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Future<List<Long>> paire = executorService.submit(nombreComplexe);

        try
        {
            ArrayList<Long> lp = (ArrayList<Long>) paire.get(20, TimeUnit.SECONDS); // timeout après 20s
            executorService.shutdown();
            t1 = System.currentTimeMillis();
            System.out.println("Temp de traitement : " + (t1 - debut) + "millisecondes");
            System.out.println("La paire est (p*q) : " + lp.get(0) + " * " + lp.get(1));
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        } catch (ExecutionException | TimeoutException e)
        {

            e.printStackTrace();
        }


    }
}

class NombreComplexe implements Callable<List<Long>>
{
    long N;

    public NombreComplexe(long n)
    {
        N = n;
    }

    @Override
    public List<Long> call() throws Exception
    {
        ArrayList<Long> res = null; // On renvoie une ArrayList contenant (ou pas) les nombres premiers trouvés
        Long maxp = N / 2; // Pas plus de la moitié de n

        Long p = 2L;
        Long q = 2L;
        boolean flag = false;

        while ((p < maxp) && !flag)
        {
            q = 2L;
            while (q <= maxp && !flag)
            {
                if ((p * q == N) & estPremier(p) & estPremier(q))
                {
                    flag = true;
                    res = new ArrayList<>();
                    res.add(p);
                    res.add(q);
                }
                q++;
            }
            p++;
        }
        if (!flag)
        {
            System.out.println("[" + Thread.currentThread().getName() + "] pas trouvé");
        }
        return res;
    }


    public boolean estPremier(long N)
    {
        boolean premier = true;
        long i = N / 2;

        while ((i >= 2) && premier)
        {
            if ((N % i) == 0)
            {
                premier = false;
            }
            i--;
        }
        return premier;

    }


}
