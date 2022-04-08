package etp7;

import java.io.IOException;
import java.net.*;
import java.nio.charset.StandardCharsets;

public class TestClientUDP {

    public static void main(String[] args) throws IOException {
        byte[] str = "ENVOI de mes DONNÉES".getBytes(StandardCharsets.UTF_8);
        InetAddress address = InetAddress.getByName("localhost");
        DatagramPacket dp = new DatagramPacket(str, str.length, address, 7001);
        DatagramSocket ds = new DatagramSocket(7002);
        ds.send(dp);
    }
}
