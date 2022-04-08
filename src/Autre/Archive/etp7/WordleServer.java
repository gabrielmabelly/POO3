package etp7;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Random;

public class WordleServer {

    private File file;
    private ArrayList<String> mots;
    private String currMot;

    public WordleServer() throws IOException {
        this.mots = new ArrayList<>();
        this.file = new File("src/etp7/liste_mot_du_francais.txt");

        BufferedReader br = new BufferedReader(new FileReader(this.file));
        String line;
        while ((line =  br.readLine()) != null) {
            if (line.length() == 5) {
                this.mots.add(line);
            }
        }
        br.close();
    }

    public void nouveauRandomMot() {
        this.currMot = this.mots.get(new Random().nextInt(this.mots.size() - 1));
    }

    public String genererReponse(String proposition) {
        char[] res = ".....".toCharArray();
        int length = this.currMot.length();
        for (int i = 0; i < length; i++) {
            if (this.currMot.charAt(i) == proposition.charAt(i)) {
                res[i] = 'o';
                continue;
            } else {
                boolean b = false;
                for (int j = 0; j < length; j++) {
                    if (this.currMot.charAt(j) == proposition.charAt(i)) {
                        b = true;
                        res[i] = '~';
                        break;
                    }
                }
                if (!b) {
                    res[i] = '.';
                }
            }
        }
        return String.valueOf(res);
    }

    public void lancer() throws IOException {
        ServerSocket serversocket = new ServerSocket(4848);
        Socket socket = serversocket.accept();

        DataInputStream dis = new DataInputStream(socket.getInputStream());
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String texterecu = dis.readUTF();
            if (texterecu.equals("---fail")) {
                dos.writeUTF(this.currMot);
                break;
            } else {
                dos.writeUTF(this.genererReponse(texterecu));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        WordleServer ws = new WordleServer();
        ws.nouveauRandomMot();
        ws.lancer();



    }
}
