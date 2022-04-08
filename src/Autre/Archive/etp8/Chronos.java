package etp8;

public class Chronos extends Thread {

    @Override
    public void run() {
        int i = 0;
        while (i < 100) {
            ++i;
            System.out.println("chronos i = " + i);
        }
    }

    public static void main(String[] args) {
        Chronos chronos = new Chronos();
        Kairos kairos = new Kairos();
        chronos.start();
        kairos.start();
    }
}
