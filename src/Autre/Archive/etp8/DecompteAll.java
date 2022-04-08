package etp8;

/*	
Ecrire un type dérivé de Thread qui sera utilisé pour décompter depuis une valeur borne jusqu’à 0 
(borne sera un attribut de ce nouveau type) 
A chaque itératon le thread affiche son nom et la valeur de son compteur
 
 */

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