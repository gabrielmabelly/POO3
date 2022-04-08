package etp10;

public class DecompteAll {

    public static void main(String[] args) {

        ThreadDecompte dcpt1 = new ThreadDecompte();
        ThreadDecompte dcpt2 = new ThreadDecompte();

        dcpt1.start();
        dcpt2.start();

        System.out.println("[Main] et je vais décompter de 100 à 0");
        for (int i = 100; i >=0; i--) {
            System.out.println("[Main]>:" +i);
        }
        System.out.println("[Main]>: J'ai fini !! ");


    }

}

class ThreadDecompte extends Thread {

    Integer borne;

    @Override
    public void run() {
        System.out.println("je m'appelle " + this.getName() + " et je vais décompter de "+ this.getBorne()+" à 0");
        for (int i = 100; i >=0; i--) {
            System.out.println("[" + this.getName() + " ]:" +i);
            try {
                Thread.sleep(250);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("[" + this.getName() + ": J'ai fini !! ");

    }

    public Integer getBorne() {
        return borne;
    }

    public void setBorne(Integer borne) {
        this.borne = borne;
    }



}