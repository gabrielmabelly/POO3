package merde;

public class Exercice1_5_4 {

	public static void courseDeThreader() {
		
		Relayeur jo = new Relayeur(1, null);
		jo.setName("Jo");
		Relayeur jack = new Relayeur(2, jo);
		jack.setName("Jack");
		Relayeur william = new Relayeur(3,jack);
		william.setName("William");
		Relayeur averell= new Relayeur(4, william);
		averell.setName("Averell");
		
		jo.start();
		jack.start();
		william.start();
		averell.start();
	}
	
	public static void courseDeRunner() {
		
		Runner runner1 = new Runner(1, null);
		Thread jo = new Thread(runner1);
		jo.setName("Jo");
		
		
		Runner runner2 = new Runner(2, null);
		Thread jack = new Thread(runner2);
		jack.setName("Jack");
		
		Runner runner3 = new Runner(3, null);
		Thread william= new Thread(runner3);
		william.setName("William");
		
		Runner runner4 = new Runner(4, null);
		Thread averell= new Thread(runner4);
		averell.setName("Averell");
		
		jo.start();
		jack.start();
		william.start();
		averell.start();
	}
	
	
	public static void main(String[] args) {
	
//		Exercice1_5_3.courseDeThreader();
		Exercice1_5_4.courseDeRunner();
		
	}

}
