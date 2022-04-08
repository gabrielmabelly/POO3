package etp2;

import java.io.*;

public class FluxBinaire {

    public int lecture(InputStream fis) {
        int res = 0;
        try {
            res = fis.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }

    public void ecriture(OutputStream fs, int nb) {
        try {
            fs.write(nb);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        FluxBinaire fb = new FluxBinaire();
        File file = new File("testflux/ints");

        try {
            switch (1) {
                case 0:
                    FileOutputStream fos = new FileOutputStream(file, true);

                    fb.ecriture(fos, 12);
                    fb.ecriture(fos, -25);
                    fb.ecriture(fos, 4584789);
                    fb.ecriture(fos, -1);
                    fb.ecriture(fos, 17);
                    fb.ecriture(fos, 56);
                    fos.close();
                    break;
                case 1:
                    FileInputStream fis = new FileInputStream(file);

                    if (!file.exists() || file.isDirectory()) {
                        System.err.println("NON");
                        System.exit(1);
                    }

                    System.out.println(fb.lecture(fis));
                    System.out.println(fb.lecture(fis));
                    System.out.println(fb.lecture(fis));
                    System.out.println(fb.lecture(fis));
                    System.out.println(fb.lecture(fis));
                    System.out.println(fb.lecture(fis));
                    fis.close();
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
