package Etape14.Exercice4;


public class Main
{
    public static void main(String[] args) throws InterruptedException
    {
        Enchère enchère = new Enchère(10);

        Acheteur acheteur = new Acheteur(enchère, "acheteur");
        Acheteur acheteur1 = new Acheteur(enchère, "acheteur1");
        Acheteur acheteur2 = new Acheteur(enchère, "acheteur2");
        Acheteur acheteur3 = new Acheteur(enchère, "acheteur3");
        Acheteur acheteur4 = new Acheteur(enchère, "acheteur4");
        Acheteur acheteur5 = new Acheteur(enchère, "acheteur5");
        Acheteur acheteur6 = new Acheteur(enchère, "acheteur6");
        Acheteur acheteur7 = new Acheteur(enchère, "acheteur7");


        enchère.start();
        System.out.println("Mise à prix en cours");
        enchère.join();
        System.out.println("La mise à prix est de : " + enchère.miseAPrix);
        System.out.println("------------------------ Début des enchères ------------------------");

        acheteur.start();
        acheteur1.start();
        acheteur2.start();
        acheteur3.start();
        acheteur4.start();
        acheteur5.start();
        acheteur6.start();
        acheteur7.start();

        Thread.sleep(120000); // Attente de 2mns

        System.out.println("\nLe gagnant de l'enchère est " + enchère.dernierAcheteur.name + " avec une enchère de : " + enchère.derniereEnchère); // Le commissaire annonce le gagnant


    }
}
