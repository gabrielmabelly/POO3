package etp8;

import java.util.Random;

public class Coureur extends Thread {

    private int num;

    public Coureur(int num) {
        super();
        this.num = num;
    }

    @Override
    public void run() {
        int i = 0;
        System.out.println("Début de la course de " + num);
        long startTime = System.nanoTime();
        while (i < 10000) {
            i += new Random().nextInt(5000);
            System.out.println("Coureur " + this.num + " -> " + i + "/10000m");
        }

        System.out.println("Fin de la course de " + num + " en " + (System.nanoTime() - startTime) + " μs");
    }

    public static void main(String[] args) {
        new Coureur(1).start();
        new Coureur(2).start();
    }
}