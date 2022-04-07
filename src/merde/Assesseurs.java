package merde;

public class Assesseurs extends Thread {

	Candidat[] finale;
	Urne monUrne;
	
	public Assesseurs(Candidat[] finale, Urne monUrne) {
		super();
		this.finale = finale;
		this.monUrne = monUrne;
	}


	@Override
	public void run() {
		super.run();
		
		
		for (int i = 0; i < 100000; i++) {
			int bulletin = monUrne.getBulletin();
			System.out.println("[" + this.getName() + "] plus 1 pour "+ finale[bulletin].nom);
			finale[bulletin].nbVoix++;
		}
	}
}
