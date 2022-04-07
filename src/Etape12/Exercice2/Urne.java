package Etape12.Exercice2;

import java.util.Random;

public class Urne
{
    public int genereBulletin()
    {
        Random random = new Random();

        return random.nextInt(2);
    }


}
