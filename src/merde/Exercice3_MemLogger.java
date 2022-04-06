package merde;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class Exercice3_MemLogger {

    public static void main(String[] args) throws InterruptedException {

        MemoryLoggerg ml = new MemoryLoggerg(new File(".."), "monLoggerMemoire");

        Thread logger = new Thread(ml);
        logger.setDaemon(true);
        logger.start();
        Thread.sleep(5000);
    }

}

class MemoryLoggerg extends File implements Runnable {

    private static final long serialVersionUID = 1L;

    public MemoryLoggerg(File parent, String child) {
        super(parent, child);
        try {
            this.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void run() {

        try (PrintWriter pw = new PrintWriter(this)) {

            do {
                Thread.sleep(250);
                long nbPs = Runtime.getRuntime().availableProcessors();
                long libre = Runtime.getRuntime().freeMemory();
                long totale = Runtime.getRuntime().totalMemory();
                String log = "Nombre Processeurs dispo : " + nbPs;
                log += " et mémoire consomée : " + (totale - libre);
                pw.println(log);
                pw.flush();
            } while (true);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}