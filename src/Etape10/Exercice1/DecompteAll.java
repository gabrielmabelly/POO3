package Etape10.Exercice1;

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
		

		
		
	}

}

class ThreadDecompte extends Thread {

	Integer borne;
	
	@Override
	public void run() {
		System.out.println("je m'appelle " + this.getName() + " et je vais décompter de "+ this.getBorne()+" à 0");
		for (int i = 0; i < 100 ; i++) {
			try
			{
				Thread.sleep(100);
			} catch (InterruptedException e)
			{
				e.printStackTrace();
			}
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