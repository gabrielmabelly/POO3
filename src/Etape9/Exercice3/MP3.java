package Etape9.Exercice3;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class MP3 extends Thread
{
    private String chemin;

    public MP3(String chemin)
    {
        this.chemin = chemin;
    }

    public void run()
    {
        try
        {
            Player player = new Player(new FileInputStream(this.chemin));
            player.play();

        } catch (JavaLayerException e)
        {
            e.printStackTrace();
        } catch (FileNotFoundException e)
        {
            System.err.println("Le chemin donné n'est pas le bon.");
            e.printStackTrace();
        }
    }


}
