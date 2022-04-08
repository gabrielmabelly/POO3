package etp8;

public class Kairos extends Thread {
    @Override
    public void run() {
        int i = 0;
        while (i < 100) {
            ++i;
            System.out.println("kairos i = " + i);
        }
    }

}
