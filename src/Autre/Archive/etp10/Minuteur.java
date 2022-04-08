package etp10;

import java.io.IOException;
import java.util.Scanner;

public class Minuteur {

    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner clavier = new Scanner(System.in);

        ThreadChronoV3 chronov3 = new ThreadChronoV3();
        chronov3.setName("ChronoV3");
        chronov3.start();

        while (true) {
            clavier.nextLine();
            chronov3.interrupt();
            //Thread.sleep(50); // on suspend 50ms pour que chronoV3 ait le temps de redémarrer
        }
    }

}

class ThreadChronoV3 extends Thread {

    Scanner pause;

    @Override
    public void run() {
        pause = new Scanner(System.in);
        long cumul = 0;
        long reste;
        int temps = 600;
        boolean stop = false;

        while (true) {

            System.out.println("Temps -> " + temps);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                if (stop) {
                    System.out.println("Stop");
                    System.exit(0);
                } else {
                    System.out.println("Pause 5 secondes");
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                    stop = true;
                    Thread.interrupted(); // on abaisse le flag
                }
            }

            temps--;
        }
    }

}
