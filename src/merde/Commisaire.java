package merde;


/*4. On s'intéresse à une processus de vente aux enchères. Le main représente le commissaire de vente qui détient le
produit et tient à jour le montant de l'enchère accessible par tous. Des Thread acheteurs vont proposer des prix d'achat
pour le produit afin d'essayer d'acquérir le produit. Le commissaire fait une mise à prix pour le produit après quoi
chaque acheteur (jusque là en attente de cette mise à prix) peut faire seulement 5 propositions (on ajoutera une valeur
 aléatoire entre 1 et 5 euros à la dernière enchère enregistrée ou au prix initial pour la toute première enchère).
 Il s'agit d'une vente à la bougie c'est à dire qu'au bout de 2mn (le temps que la bougie se consume) le commissaire
 clôture la vente et c'est l'acheteur avec l'enchère la plus haute qui emporte le produit.  */

import java.util.ArrayList;

public class Commisaire {
    public static volatile int montant = 0;
    public static String produit;
    public static Acheteur dernierAcheteur;


    public static void main(String[] args) throws InterruptedException {

        Commisaire commisaire = new Commisaire();
        Acheteur acheteur1 = new Acheteur(commisaire);
        acheteur1.setName("Acheteur 1");
        Acheteur acheteur2 = new Acheteur(commisaire);
        acheteur2.setName("Acheteur 2");
        Acheteur acheteur3 = new Acheteur(commisaire);
        acheteur3.setName("Acheteur 3");
        Acheteur acheteur4 = new Acheteur(commisaire);
        acheteur4.setName("Acheteur 4");

        acheteur1.start();
        acheteur2.start();
        acheteur3.start();
        acheteur4.start();

        // Mise à prix du produit
        produit = "Table";
        montant = 40;
        Acheteur.peutMiser = true;

        // Attente de 2 min
        Thread.sleep(1000);
        Acheteur.peutMiser = false;
        // Designer le gagnant
        System.out.println("Le gagant est : " + dernierAcheteur.getName());

    }
}
