package etp4;

import java.io.IOException;

public class FamilleMain {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Famille f1 = new Famille("Famillea", "Perea", "Merea", "Jeunefillea");
        Famille f2 = new Famille("Familleb", "Pereb", "Mereb", "Jeunefilleb");
        Famille f3 = new Famille("Famillec", "Perec", "Merec", "Jeunefillec");
        Famille f4 = new Famille("Familled", "Pered", "Mered", "Jeunefilled");
        Famille f5 = new Famille("Famillee", "Peree", "Meree", "Jeunefillee");
        Famille f6 = new Famille("Famillef", "Peref", null, null);
        Famille f7 = new Famille("Familleg", "Pereg", "Mereg", "Jeunefilleg");
        Famille f8 = new Famille("Familleh", null, "Mereh", "Jeunefilleh");

        f1.addFamilleEngendre(f2);
        f2.addFamilleEngendre(f3);
        f2.addFamilleEngendre(f4);
        f2.addFamilleEngendre(f5);
        f5.addFamilleEngendre(f6);
        f5.addFamilleEngendre(f7);
        f7.addFamilleEngendre(f8);

        Famille.save("famille.bin", f1);
        Famille fload = Famille.load("famille.bin");

        if (f1.toString().equals(fload.toString())) {
            System.out.println("La serialisation a fonctionné");
        }
    }
}
