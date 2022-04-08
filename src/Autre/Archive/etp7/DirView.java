package etp7;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;

public class DirView implements Serializable {

    static final long serialVersionUID = 42L;

    private ArrayList<File> files;

    public DirView(String dossierStr) {
        File dossier = new File(dossierStr);
        this.files = new ArrayList<>();
        for (File file : dossier.listFiles()) {
            if (file.isFile()) {
                this.files.add(file);
            }
        }
    }

    public File recupFichier(int index) {
        return this.files.get(index);
    }

    public void afficher() {
        int i = 0;
        for (File file : this.files) {
            System.out.println(i++ + " -> " + file.getName());
        }
    }
}
