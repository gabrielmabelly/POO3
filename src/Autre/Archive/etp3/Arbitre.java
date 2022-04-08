package etp3;

import java.io.*;

public class Arbitre {

    private PipedInputStream input;
    private PipedOutputStream output;

    public Arbitre() {
        this.input = new PipedInputStream();
        this.output = new PipedOutputStream();
    }

    public void proposition() {

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int i = Integer.parseInt(br.readLine());
            this.output.write(i);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.err.println("Nombre invalide");
            System.exit(1);
        }
    }

    public boolean recupererReponse() {
        boolean gagne = false;
        try {
            int reponse = this.input.read();
            switch (reponse) {
                case 0:
                    System.out.println("Gagné");
                    gagne = true; break;
                case 1:
                    System.out.println("Trop petit");
                    gagne = false; break;
                case 2:
                    System.out.println("Trop grand");
                    gagne = false; break;
                default:
                    gagne = false; break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return gagne;
    }

    public PipedInputStream getInput() {
        return input;
    }

    public PipedOutputStream getOutput() {
        return output;
    }
}
