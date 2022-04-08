package etp9;

import java.util.Random;
import java.util.Scanner;

public class Stopwatch extends Thread {

    public int i;

    @Override
    public void run() {
        i = 0;

        while (true) {
            ++i;
            if (i > 10000000) {
                i = 0;
            }
        }
    }

    public static void main(String[] args) {
        Stopwatch st = new Stopwatch();
        st.start();
        Scanner sc = new Scanner(System.in);
        while(true) {
            sc.nextLine();
            if (st.i % 10 == 0) {
                System.out.println("Bien joué");
                sc.close();
                System.exit(0);
            }
        }

    }
}