package Etape7.Exercice4;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class TestServeurUDP
{
    public static void main(String[] args) throws IOException
    {
        byte[] recep = new byte[4096];
        DatagramSocket datagramSocket = new DatagramSocket(4242);

        DatagramPacket received = new DatagramPacket(recep, recep.length);
        datagramSocket.receive(received);

        String message = new String(received.getData(), 0, received.getLength());
        System.out.println("Réception de l'adresse " + received.getAddress().getHostAddress() +
                " sur le port n°" + received.getPort() + "\n message : "+ message);
    }
}
