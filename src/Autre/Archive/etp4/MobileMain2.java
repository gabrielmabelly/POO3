package etp4;

import java.io.*;

public class MobileMain2 {

    public static void main(String[] args) {
        Mobile2 m = new Mobile2("iPhone 7", 250, 8, false, 499.99);

        try {
            System.out.println(m);
            Mobile2.save("mobile.bin", m);

            Mobile2 mload = Mobile2.load("mobile.bin");
            System.out.println(mload);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
