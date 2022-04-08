package etp7;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class TestServeurUDP {

    public static void main(String[] args) throws IOException {
        byte[] receptionOctets = new byte[2048];

        DatagramSocket socket = new DatagramSocket(7001);

        DatagramPacket reception = new DatagramPacket(receptionOctets, receptionOctets.length);
        socket.receive(reception);
        String texte = new String(reception.getData(), 0, reception.getLength());
        System.out.println("Réception de " + reception.getAddress().getHostName());
        System.out.println("Sur le port " + reception.getPort());
        System.out.println("Texte : " + texte);

    }

}
