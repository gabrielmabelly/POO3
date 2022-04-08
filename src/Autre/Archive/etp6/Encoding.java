package etp6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Encoding {

    public static void encoding(String nomfichier) {
        File file = new File(nomfichier);

        if (!file.isFile()) {
            System.err.println("Le fichier n'existe pas");
            System.exit(1);
        }


        try {
            String typeMime = Files.probeContentType(file.toPath());

            if ((typeMime!=null) && typeMime.contains("text")) {
                /*List<String> content = Files.readAllLines(file.toPath(), StandardCharsets.);

                Files.write(Path.of("a" + file.toPath()), content, Charset.forName("UTF-8"));
                */
                Path p = Paths.get("Item.java");
                ByteBuffer bb = ByteBuffer.wrap(Files.readAllBytes(p));
                CharBuffer cb = Charset.forName("windows-1252").decode(bb);
                bb = Charset.forName("UTF-8").encode(cb);
                Files.write(Path.of("a" + file.toPath()), bb.array());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }



    }

    public static void main(String[] args) {
        encoding("Item.java");
    }
}
