package etp7;

import java.io.Serializable;

public class Etudiant implements Serializable {

    String nom;
    String prenom;
    String numero;
    int age;

    public Etudiant(String nom, String prenom, String numero, int age) {
        this.nom = nom;
        this.prenom = prenom;
        this.numero = numero;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Etudiant{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", numero='" + numero + '\'' +
                ", age=" + age +
                '}';
    }

    public void affichage() {
        System.out.println(this);
    }
}
