package merde;

public class Candidat {
	
	public String nom;
	public Integer nbVoix;
	
	public Candidat(String nom, Integer nbVoix) {
		super();
		this.nom = nom;
		this.nbVoix = nbVoix;
	}

	@Override
	public String toString() {
		return "Candidat [nom=" + nom + ", nbVoix=" + nbVoix + "]";
	}
	
	public void affiche() {System.out.println(this);}
}
