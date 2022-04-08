package etp3;

import java.io.*;
import java.nio.file.Files;

public class PerfComparees {

    private static void octetParOctet(File finput, File foutput) {

        try (FileInputStream fis = new FileInputStream(finput); FileOutputStream fos = new FileOutputStream(foutput);) {
            while (fis.available() > 0) {
                fos.write(fis.read());
            }
            fis.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void groupe64octets(File finput, File foutput) {
        try (FileInputStream fis = new FileInputStream(finput); FileOutputStream fos = new FileOutputStream(foutput);) {
            byte[] buffer = new byte[64];
            int lengthRead;
            while ((lengthRead = fis.read(buffer)) > 0) {
                fos.write(buffer, 0, lengthRead);
                fos.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void bufferedStreamReadAll(File finput, File foutput) {
        try (
                BufferedInputStream fis = new BufferedInputStream(new FileInputStream(finput));
                BufferedOutputStream fos = new BufferedOutputStream(new FileOutputStream(foutput));) {

            fos.write(fis.readAllBytes());


            fis.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }



    /*
    Temps :
    Octet par octet -> 214489791 μs
    Groupe 64 octets -> 474792 μs
    BufferedStream readAll() -> 192500 μs

    BufferedStream est très efficace
     */
    public static void main(String[] args) {
        try {

            File fi = new File("perf1/image.png");
            File fo = new File("perf2/image.png");

            long d1 = System.nanoTime();
            octetParOctet(fi, fo);
            long f1 = System.nanoTime();
            Files.delete(fo.toPath());

            long d2 = System.nanoTime();
            groupe64octets(fi, fo);
            long f2 = System.nanoTime();
            Files.delete(fo.toPath());

            long d3 = System.nanoTime();
            bufferedStreamReadAll(fi, fo);
            long f3 = System.nanoTime();
            Files.delete(fo.toPath());

            System.out.println("Temps :");
            System.out.println("Octet par octet -> " + (f1 - d1) + " μs");
            System.out.println("Groupe 64 octets -> " + (f2 - d2) + " μs");
            System.out.println("BufferedStream readAll() -> " + (f3 - d3) + " μs");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
