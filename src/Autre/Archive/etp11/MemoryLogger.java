package etp11;

import java.io.*;

class MemoryLogger extends File implements Runnable {

    @Serial
    private static final long serialVersionUID = 3101L;

    public MemoryLogger(File parent, String child) {
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

            while (true) {
                Thread.sleep(250);
                long nbPs = Runtime.getRuntime().availableProcessors();
                long libre = Runtime.getRuntime().freeMemory();
                long totale = Runtime.getRuntime().totalMemory();
                String log = "Nombre Processeurs dispo : " + nbPs;
                log += " et mémoire consomée : " + (totale - libre);
                pw.println(log);
                pw.flush();
            }

        } catch (FileNotFoundException | InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws InterruptedException {
        MemoryLogger ml = new MemoryLogger(new File("."), "monLoggerMemoire");

        Thread logger = new Thread(ml);
        logger.setDaemon(true);
        logger.start();
        Thread.sleep(5000);
    }

}


