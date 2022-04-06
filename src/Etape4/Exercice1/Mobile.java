package Etape4.Exercice1;

import jdk.internal.org.objectweb.asm.commons.SerialVersionUIDAdder;

import java.io.Serializable;

public class Mobile implements Serializable
{
    String contructeur;
    String modèle;
    Integer nbPixelsFront;
    static final long serialVersionUID = 424242;




    @Override
    public String toString()
    {
        return "Mobile{" +
                "contructeur='" + contructeur + '\'' +
                ", modèle='" + modèle + '\'' +
                ", nbPixelsFront=" + nbPixelsFront +
                ", memoire=" + memoire +
                ", capacité=" + capacité +
                ", cinqG=" + cinqG +
                ", prix=" + prix +
                '}';
    }

    Integer memoire;
    Integer capacité;
    Boolean cinqG;
    Double prix;

    public Mobile(String contructeur, String modèle, Integer nbPixelsFront, Integer memoire, Integer capacité, Boolean cinqG, Double prix)
    {
        this.contructeur = contructeur;
        this.modèle = modèle;
        this.nbPixelsFront = nbPixelsFront;
        this.memoire = memoire;
        this.capacité = capacité;
        this.cinqG = cinqG;
        this.prix = prix;
    }
}
