package etp4;

import java.io.*;

public class MobileMain {

    public static void main(String[] args) {
        Mobile m1 = new Mobile("iPhone 7", 250, 8, false, 499.99);
        Mobile m2 = new Mobile("Oppo find X3", 450, 16, true, 1149.95);
        Mobile m3 = new Mobile("Xiaomi redmi note 10", 130, 4, true, 159);

        try {
            Mobile.save("mobile1.bin", m1);
            Mobile.save("mobile2.bin", m2);
            Mobile.save("mobile3.bin", m3);

            Mobile m2load = Mobile.load("mobile2.bin");

            if (m2.getModele().equals(m2load.getModele())) {
                System.out.println("La serialisation a marché");
            }


        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
