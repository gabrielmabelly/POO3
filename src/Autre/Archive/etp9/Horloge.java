package etp9;

import com.sun.tools.javac.Main;

import javax.sound.sampled.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Horloge extends Thread {

    public Horloge() {
        this.setDaemon(true);
    }

    @Override
    public void run() {
        Musique m = new Musique();
        m.start();
        int i = 0;
        while (true) {

            if (i % 10 == 0) {
                System.out.println(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime()));
            }

            ++i;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Horloge h = new Horloge();
        h.start();
        Thread.sleep(10000);
        h.interrupt();
    }
}
