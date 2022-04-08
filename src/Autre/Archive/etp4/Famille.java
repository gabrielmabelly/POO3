package etp4;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class Famille implements Serializable {

    @Serial
    private static final long serialVersionUID = 369693L;

    private String nomDeFamille;
    private String prenomPere;
    private String prenomMere;
    private String nomJeunefilleMere;
    private ArrayList<Famille> famillesEngendrees;

    public Famille(String nomDeFamille, String prenomPere, String prenomMere, String nomJeunefilleMere) {
        this.nomDeFamille = nomDeFamille;
        this.prenomPere = prenomPere;
        this.prenomMere = prenomMere;
        this.nomJeunefilleMere = nomJeunefilleMere;
        this.famillesEngendrees = new ArrayList<>();
    }

    public static void save(String filepath, Famille mobile) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filepath));
        oos.writeObject(mobile);
        oos.close();
    }

    public static Famille load(String filepath) throws IOException, ClassNotFoundException {
        if (!Files.exists(Path.of(filepath))) {
            System.err.println("Fichier introuvable");
            System.exit(1);
        }
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filepath));
        Famille famille = (Famille) ois.readObject();
        ois.close();

        return famille;
    }

    public String getNomDeFamille() {
        return nomDeFamille;
    }

    public void setNomDeFamille(String nomDeFamille) {
        this.nomDeFamille = nomDeFamille;
    }

    public String getPrenomPere() {
        return prenomPere;
    }

    public void setPrenomPere(String prenomPere) {
        this.prenomPere = prenomPere;
    }

    public String getPrenomMere() {
        return prenomMere;
    }

    public void setPrenomMere(String prenomMere) {
        this.prenomMere = prenomMere;
    }

    public ArrayList<Famille> getFamillesEngendrees() {
        return famillesEngendrees;
    }

    public String getNomJeunefilleMere() {
        return nomJeunefilleMere;
    }

    public void setNomJeunefilleMere(String nomJeunefilleMere) {
        this.nomJeunefilleMere = nomJeunefilleMere;
    }

    public void addFamilleEngendre(Famille famillesEngendrees) {
        this.famillesEngendrees.add(famillesEngendrees);
    }

    @Override
    public String toString() {
        return "Famille{" +
                "nomDeFamille='" + nomDeFamille + '\'' +
                ", prenomPere='" + prenomPere + '\'' +
                ", prenomMere='" + prenomMere + '\'' +
                ", nomJeunefilleMere='" + nomJeunefilleMere + '\'' +
                ", famillesEngendrees=" + famillesEngendrees +
                '}';
    }
}
