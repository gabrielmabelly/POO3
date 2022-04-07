package merde;

public class Elections {

	public static void main(String[] args) {
		
		Candidat duke = new Candidat("Duke", 0);
		Candidat bugee = new Candidat("Bugee", 0);
		
		Candidat[] finale = new Candidat[2];
		finale[0]=duke;
		finale[1]=bugee;
		
		Urne urne1 = new Urne();
		Urne urne2 = new Urne();
		
		Assesseurs jo = new Assesseurs(finale,urne1);
		jo.setName("Jo");
		Assesseurs donald = new Assesseurs(finale,urne2);
		donald.setName("Bugee");
		
		jo.start();donald.start();
		
		try {
			jo.join();
			donald.join();
		} catch (InterruptedException e) {e.printStackTrace();}
	
		
		System.out.println("Voici le score de cette finale ");
		System.out.println("Duke > " + finale[0] + "< contre  Bugee > " + finale[1] + "<");
	}
}
