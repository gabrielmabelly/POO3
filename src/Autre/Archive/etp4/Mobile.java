package etp4;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class Mobile implements Serializable {

    private String modele;
    private int nbPixelsFront;
    private int memoire;
    private boolean capacite5g;
    private double prix;

    public Mobile(String modele, int nbPixelsFront, int memoire, boolean capacite5g, double prix) {
        this.modele = modele;
        this.nbPixelsFront = nbPixelsFront;
        this.memoire = memoire;
        this.capacite5g = capacite5g;
        this.prix = prix;
    }

    public static void save(String filepath, Mobile mobile) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filepath));
        oos.writeObject(mobile);
        oos.close();
    }

    public static Mobile load(String filepath) throws IOException, ClassNotFoundException {
        if (!Files.exists(Path.of(filepath))) {
            System.err.println("Fichier introuvable");
            System.exit(1);
        }
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filepath));
        Mobile mobile = (Mobile) ois.readObject();
        ois.close();

        return mobile;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public int getNbPixelsFront() {
        return nbPixelsFront;
    }

    public void setNbPixelsFront(int nbPixelsFront) {
        this.nbPixelsFront = nbPixelsFront;
    }

    public int getMemoire() {
        return memoire;
    }

    public void setMemoire(int memoire) {
        this.memoire = memoire;
    }

    public boolean isCapacite5g() {
        return capacite5g;
    }

    public void setCapacite5g(boolean capacite5g) {
        this.capacite5g = capacite5g;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }
}
