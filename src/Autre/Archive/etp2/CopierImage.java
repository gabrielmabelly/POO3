package etp2;

import java.io.*;

public class CopierImage {

    public static void copierBin(File fsource, File fdest) throws IOException {
        if (!fsource.exists() || fsource.isDirectory() || fdest.exists() || fdest.isDirectory()) {
            System.err.println("La source n'existe pas ou la destination existe");
            System.exit(1);
        }

        if (!fsource.getName().substring(fsource.getName().lastIndexOf(".")).equals(".png")) {
            System.err.println("La source n'est pas un png");
            System.exit(2);
        }

        FileInputStream fis = null;
        FileOutputStream fos = null;

        try  {
            fis = new FileInputStream(fsource);
            fos = new FileOutputStream(fdest, true);

            byte[] buffer = new byte[1024];
            int lengthRead;
            while ((lengthRead = fis.read(buffer)) > 0) {
                fos.write(buffer, 0, lengthRead);
                fos.flush();
            }
        } catch (IOException e) {
                e.printStackTrace();
        } finally {
            fis.close();
            fos.close();
        }

    }

    public static void main(String[] args) throws IOException {
        copierBin(new File("testcopier/image.png"), new File("testcopier/image2.png"));
    }
}
