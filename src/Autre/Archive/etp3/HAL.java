package etp3;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.util.Random;

public class HAL {

    private PipedInputStream input;
    private PipedOutputStream output;
    private int nombreGagnant;

    public HAL() {
        this.input = new PipedInputStream();
        this.output = new PipedOutputStream();
        this.nombreGagnant = (new Random().nextInt(50) + 1);
    }

    public void checkReponse() {
        try {
            int reponse = this.input.read();

            if (this.nombreGagnant == reponse) {
                this.output.write(0);
            } else if (this.nombreGagnant > reponse) {
                this.output.write(1);
            } else if (this.nombreGagnant < reponse) {
                this.output.write(2);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public PipedInputStream getInput() {
        return input;
    }

    public PipedOutputStream getOutput() {
        return output;
    }

    public static void main(String[] args) {
        HAL hal = new HAL();
        Arbitre arbitre = new Arbitre();
        boolean gagne = false;
        try {
            arbitre.getInput().connect(hal.getOutput());
            hal.getInput().connect(arbitre.getOutput());

            while (!gagne) {
                arbitre.proposition();
                hal.checkReponse();
                gagne = arbitre.recupererReponse();

                arbitre.getOutput().flush();
                hal.getOutput().flush();
            }
            hal.getInput().close();
            hal.getOutput().close();
            arbitre.getInput().close();
            arbitre.getOutput().close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
