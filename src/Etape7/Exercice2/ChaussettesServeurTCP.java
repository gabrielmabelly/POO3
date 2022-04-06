package Etape7.Exercice2;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ChaussettesServeurTCP
{
    public static void main(String[] args) throws IOException, ClassNotFoundException
    {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        ServerSocket serverSocket = new ServerSocket(4848);
        Socket socket = serverSocket.accept();


        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
        ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());

        try
        {
            int[] tab = (int[]) objectInputStream.readObject();
            StringBuilder receivedMessage = new StringBuilder();
            for (int i : tab)
            {
                receivedMessage.append(i);
            }

            System.out.println("Message envoyé par le client : " + receivedMessage);

            System.out.println("Maintenant entrez un message à renvoyer au client : ");
            dataOutputStream.writeUTF(bufferedReader.readLine());


        } catch (Exception e)
        {
            System.err.println("Mauvais type envoyé.");
            e.printStackTrace();
        }


        dataOutputStream.flush();
        dataOutputStream.close();
        objectInputStream.close();
        bufferedReader.close();
        socket.close();


    }

}
