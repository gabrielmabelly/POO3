package Etape7.Exercice4;

import java.io.IOException;
import java.net.*;
import java.nio.charset.StandardCharsets;

public class TestClientUDP
{
    public static void main(String[] args) throws IOException
    {
        byte[] msg = "test".getBytes(StandardCharsets.UTF_8);

        DatagramPacket datagramPacket = new DatagramPacket(msg, msg.length, InetAddress.getByName("localhost"), 4242);
        DatagramSocket datagramSocket = new DatagramSocket(4141);
        datagramSocket.send(datagramPacket);

    }
}
