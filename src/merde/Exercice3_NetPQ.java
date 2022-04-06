package merde;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Exercice3_NetPQ {

    public static void main(String[] args) {

        Long t0 = System.currentTimeMillis();
        Long t1;
        Long nombre = 17113L;

        MineurPetQ unMineur = new MineurPetQ(nombre);

        ExecutorService executant = Executors.newSingleThreadExecutor();

        Future<List<Long>> laPaire = executant.submit(unMineur);

        try {
            ArrayList<Long> lp = (ArrayList<Long>) laPaire.get();
            System.out.println("on a trouve la paire suivante p = " + lp.get(0) + " et q = " + lp.get(1));
            executant.shutdown();
            t1 = System.currentTimeMillis();
            long duree=t1-t0;
            System.out.println("Temps de traitement : " + duree);

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}

class MineurPetQ implements Callable<List<Long>> {

    long N;

    public MineurPetQ(long N) {
        this.N = N;
    }

    public boolean estPremier(long N) {
        boolean premier = true;
        long i = N / 2;

        while ((i >= 2) && premier) {
            if ((N % i) == 0) {
                premier = false;
            }
            i--;
        }
        return premier;
    }

    @Override
    public List<Long> call() {

        ArrayList<Long> res = null;
        Long maxp = N / 2;

        Long p = 2L;
        Long q = 2L;
        boolean trouve = false;

        while ((p < maxp) && !trouve) {
            q = 2L;
            while ((q <= maxp) && !trouve) {
                if ((p * q == N) & estPremier(p) & estPremier(q)) {
                    String nom = Thread.currentThread().getName();
                    trouve = true;
                    res = new ArrayList<Long>(2);
                    res.add(p);
                    res.add(q);
                }
                q = q + 1;
            }
            p = p + 1;
        }
        if (!trouve) {
            String nom = Thread.currentThread().getName();
            System.out.println("[" + nom + "] On a pas trouvé  ");
        }

        return res;
    }

}
