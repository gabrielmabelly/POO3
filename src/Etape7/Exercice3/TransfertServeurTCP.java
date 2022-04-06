package Etape7.Exercice3;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TransfertServeurTCP
{
    public static void main(String[] args) throws IOException, ClassNotFoundException
    {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        ServerSocket serverSocket = new ServerSocket(4848);
        Socket socket = serverSocket.accept();

        DirView dirView = new DirView(".\\src\\Etape7\\Exercice3\\sourceFiles");


        ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());

        objectOutputStream.writeObject(dirView);


        objectOutputStream.flush();
        objectOutputStream.close();
        objectInputStream.close();
        bufferedReader.close();
        socket.close();

    }

}
