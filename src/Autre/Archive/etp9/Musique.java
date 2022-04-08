package etp9;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Musique extends Thread {

    public Musique() {
        this.setDaemon(true);
    }

    @Override
    public void run() {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("song.wav").getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.loop(0);
        } catch (LineUnavailableException | IOException | UnsupportedAudioFileException e) {
            e.printStackTrace();
        }
    }

}
