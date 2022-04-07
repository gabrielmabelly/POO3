package merde;

/*4. On s'intéresse à une processus de vente aux enchères. Le main représente le commissaire de vente qui détient le
produit et tient à jour le montant de l'enchère accessible par tous. Des Thread acheteurs vont proposer des prix d'achat
pour le produit afin d'essayer d'acquérir le produit. Le commissaire fait une mise à prix pour le produit après quoi
chaque acheteur (jusque là en attente de cette mise à prix) peut faire seulement 5 propositions (on ajoutera une valeur
 aléatoire entre 1 et 5 euros à la dernière enchère enregistrée ou au prix initial pour la toute première enchère).
 Il s'agit d'une vente à la bougie c'est à dire qu'au bout de 2mn (le temps que la bougie se consume) le commissaire
 clôture la vente et c'est l'acheteur avec l'enchère la plus haute qui emporte le produit.  */

public class Acheteur extends Thread {
    public static boolean peutMiser = false;
    public int nbPropositions;
    public int offre;
    public Commisaire commisaire;

    public Acheteur(Commisaire commisaire) {
        this.commisaire = commisaire;
        this.nbPropositions = 0;
        this.offre = 0;
    }

    synchronized int faireEnchere() {
            nbPropositions++;
            offre = (int) (Commisaire.montant + (Math.random() * (5 - 1)) + 1);
            return offre;
    }


    @Override
    public void run() {
        super.run();

        while (true) {
            if (peutMiser && nbPropositions < 50) {
                Commisaire.montant = this.faireEnchere();
                System.out.println(this.getName() + " à misé : " + offre);
                Commisaire.dernierAcheteur = this;
            } else if (nbPropositions >= 50){
                System.out.println(this.getName() + " a déjà fait 5 propositions");
                break;
            }


            try {
                Thread.sleep(250);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}
