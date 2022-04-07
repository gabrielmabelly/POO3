package merde;

public class Exercice1_5_3 {

	public static void courseDeThreader() {

		Relayeur jo = new Relayeur(1, null);
		jo.setName("Jo");
		Relayeur jack = new Relayeur(2, jo);
		jack.setName("Jack");
		Relayeur william = new Relayeur(3, jack);
		william.setName("William");
		Relayeur averell = new Relayeur(4, william);
		averell.setName("Averell");

		jo.start();
		jack.start();
		william.start();
		averell.start();
	}

	public static void main(String[] args) {

		Exercice1_5_3.courseDeThreader();

	}

}
