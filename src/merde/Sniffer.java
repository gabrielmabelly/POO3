package merde;

import java.io.File;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.*;

public class Sniffer implements Callable<ArrayList<File>> {

    private File folder;

    public Sniffer(File folder) {
        this.folder = folder;
    }

    @Override
    public ArrayList<File> call() {
        ArrayList<File> arrayList = new ArrayList<>();
        if (!this.folder.isDirectory()) {
            return arrayList;
        }
        LocalDate lt = LocalDate.now();
        LocalDate avant = lt.minusDays(1);
        LocalDate apres = lt.plusDays(1);
        for (File f : this.folder.listFiles()) {
            LocalDate dateFichier = Instant.ofEpochMilli(f.lastModified()).atZone(ZoneId.systemDefault()).toLocalDate();
            if (dateFichier.isAfter(avant) && dateFichier.isBefore(apres)) {
                arrayList.add(f);
            }
        }
        return arrayList;
    }

        public static void main(String[] args) {
            File src = new File("src");
            HashMap<File, Future<ArrayList<File>>> map = new HashMap<>();
            int nb = Objects.requireNonNull(src.list()).length;
            ExecutorService executant = Executors.newFixedThreadPool(nb);
            for (String s : src.list()) {
            File f = new File("src/" + s);
            map.put(f, executant.submit(new Sniffer(f)));
        }

        System.out.println("Recherche....");

        map.forEach((k, v) -> {
            try {
                if (!k.isDirectory()) {
                    return;
                }
                System.out.println("===> " + k);
                ArrayList<File> array = v.get();
                for (File f : array) {
                    System.out.println("   " + f.getName());
                }
                System.out.println();
                System.out.println();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }

        });

        executant.shutdown();



    }
}
