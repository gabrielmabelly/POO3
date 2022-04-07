package Etape13.Exercice1;

public class Main
{
    public static void main(String[] args)
    {
        CoureurJoin jean = new CoureurJoin(1,"jean");
        CoureurJoin charles = new CoureurJoin(1,"charles");

        Starter starter = new Starter();

        starter.start();

        try
        {
            starter.join();
            System.out.println("------------------------!! TOP DEPART !!------------------------");
            jean.start();
            charles.start();

        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}
