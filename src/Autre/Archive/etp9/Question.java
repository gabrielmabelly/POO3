package etp9;

import java.util.Scanner;

public class Question extends Thread {

    public String question;
    public String rep;

    public Question() {
        this.question = "Combien font 2+2 ?";
        this.rep = "4";
    }

    @Override
    public void run() {
        Scanner sc = new Scanner(System.in);
        String rep = sc.nextLine();
        if (rep.equals(this.rep)) {
            System.out.println("Ok");
        } else {
            System.out.println("Non ok");
        }
        this.interrupt();
    }

    public static void main(String[] args) {
        Question qu = new Question();
        qu.start();
        System.out.println("Question : " + qu.question);
        long start = System.currentTimeMillis();
        long end = start + 3*1000;
        while (System.currentTimeMillis() < end) {
            if (!qu.isAlive()) {
                break;
            }
        }

        System.out.println("La réponse était : " + qu.rep);
        System.exit(1);
    }
}

