package Etape10.Exercice2;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Chrono extends Thread
{

    Date date;
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm:ss:SS");

    public static void main(String[] args)
    {
        Chrono chrono = new Chrono();
        chrono.run();

    }

    public void run()
    {

        while (true)
        {
            date = new Date();
            try
            {


                System.out.println(simpleDateFormat.format(date));
                Thread.sleep(100);


            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }


        }

    }


}
