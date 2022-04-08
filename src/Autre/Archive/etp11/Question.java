package etp11;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.*;

public class Question implements Callable<String> {

    public String question;
    public String rep;

    public Question() {
        this.question = "Combien font 2+2 ?";
        this.rep = "4";
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Question qu = new Question();
        ExecutorService executant = Executors.newSingleThreadExecutor();
        Future<String> rep = executant.submit(qu);

        System.out.println("La réponse était : " + rep.get());
        System.exit(1);
    }

    @Override
    public String call() throws Exception {
        System.out.println("Question : " + this.question);
        long start = System.currentTimeMillis();
        long end = start + 3*1000;
        while (System.currentTimeMillis() < end) {
        }
        Scanner sc = new Scanner(System.in);
        String rep = sc.nextLine();
        if (rep.equals(this.rep)) {
            System.out.println("Ok");
        } else {
            System.out.println("Non ok");
        }
        return this.rep;
    }
}

