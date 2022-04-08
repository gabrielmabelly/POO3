package etp3;

import java.io.*;

public class FluxBinaire {

    public int lecture(DataInputStream fis) {
        int res = -2;
        try {
            res = fis.readInt();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }

    public void ecriture(DataOutputStream fs, int nb) {
        try {
            fs.writeInt(nb);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        FluxBinaire fb = new FluxBinaire();
        File file = new File("ints");
        try {
            System.out.println("Output");
            DataOutputStream fos = new DataOutputStream(new FileOutputStream(file));
            fb.ecriture(fos, 12);
            fb.ecriture(fos, -25);
            fb.ecriture(fos, 4584789);
            fb.ecriture(fos, -1);
            fb.ecriture(fos, 17);
            fb.ecriture(fos, 56);
            fos.close();

            System.out.println("Input");
            DataInputStream fis = new DataInputStream(new FileInputStream(file));

            if (!file.exists() || file.isDirectory()) {
                System.err.println("Le fichier n'existe pas");
                System.exit(1);
            }

            System.out.println(fb.lecture(fis));
            System.out.println(fb.lecture(fis));
            System.out.println(fb.lecture(fis));
            System.out.println(fb.lecture(fis));
            System.out.println(fb.lecture(fis));
            System.out.println(fb.lecture(fis));
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
