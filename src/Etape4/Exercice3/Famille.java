package Etape4.Exercice3;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

public class Famille implements Serializable
{
    String nomDeFamille;
    String prénomPère;
    String prénomMère;
    String nomJeuneFilleMère;
    ArrayList<Famille> familles;


    @Override
    public String toString()
    {
        return "Famille{" +
                "nomDeFamille='" + nomDeFamille + '\'' +
                ", prénomPère='" + prénomPère + '\'' +
                ", prénomMère='" + prénomMère + '\'' +
                ", nomJeuneFilleMère='" + nomJeuneFilleMère + '\'' +
                ", \n familles=" + familles +
                '}';
    }

    public Famille(String nomDeFamille, String prénomPère, String prénomMère, String nomJeuneFilleMère, ArrayList<Famille> familles)
    {
        this.nomDeFamille = nomDeFamille;
        this.prénomPère = prénomPère;
        this.prénomMère = prénomMère;
        this.nomJeuneFilleMère = nomJeuneFilleMère;
        this.familles = familles;
    }



}
