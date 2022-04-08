package etp7;

import java.io.*;
import java.net.Socket;

public class WordleClient {

    public void lancer() throws IOException {
        Socket socket = new Socket("localhost", 4848);
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
        DataInputStream dis = new DataInputStream(socket.getInputStream());
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean win = false;
        int i = 1;
        String texte, res;

        while (!win) {
            System.out.println("Proposition "+ i +" : ");
            texte = br.readLine();
            if (texte.length() != 5) {
                continue;
            }

            dos.writeUTF(texte);
            dos.flush();


            res = dis.readUTF();
            System.out.println(res);

            if (res == "ooooo") {
                win = true;
                System.out.println("Gagné !!");
            }

            if (!win && i == 6) {
                dos.writeUTF("---fail");
                System.err.println("FAIL, le mot était : " + dis.readUTF());
                break;
            }
            i++;

        }
    }

    public static void main(String[] args) throws IOException {
        WordleClient wc = new WordleClient();
        wc.lancer();
    }
}
