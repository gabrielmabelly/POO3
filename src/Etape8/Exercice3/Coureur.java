package Etape8.Exercice3;

import java.util.Scanner;

public class Coureur extends Thread
{
    private int numeroCoureur;
    private int distanceParcourue;
    private String nomCoureur;

    public Coureur(int num, String nom)
    {
        this.numeroCoureur = num;
        this.distanceParcourue = 1;
        this.nomCoureur = nom;
    }


    public void run()
    {
        System.out.println("Début de la course du coureur n°" + this.numeroCoureur);

        long mili = System.currentTimeMillis(); // On stocke quand la course commennce
        while (this.distanceParcourue <= 10000)
        {
            System.out.println("Coureur n°" + this.numeroCoureur + " (" + this.nomCoureur + ") - " + this.distanceParcourue + "m parcourus.");
            this.distanceParcourue++;
        }
        System.out.println("Le coureur n°" + this.numeroCoureur + " (" + this.nomCoureur + ") a terminé sa course en " + (System.currentTimeMillis() - mili) + " milisecondes."); // On affiche combien de temsp la course a duré
    }


    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        Coureur jean = new Coureur(0, "Jean");
        Coureur charles = new Coureur(1, "Charles");

        System.out.println("Appuyez sur n'importe quelle touche puis entrée : ");
        scanner.next();


        jean.start();
        charles.start();


    }

}
