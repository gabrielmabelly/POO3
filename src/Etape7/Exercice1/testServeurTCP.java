package Etape7.Exercice1;

import com.sun.security.ntlm.Server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class testServeurTCP
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        ServerSocket serverSocket = new ServerSocket(4848);
        Socket socket = serverSocket.accept();


        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
        DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());


        String receivedMessage = dataInputStream.readUTF();
        System.out.println("Message envoyé par le client : " + receivedMessage);

        System.out.println("Maintenant entrez un message à renvoyer au client : ");
        dataOutputStream.writeUTF(bufferedReader.readLine());


        dataOutputStream.flush();
        dataOutputStream.close();
        dataInputStream.close();
        bufferedReader.close();
        socket.close();


    }

}
