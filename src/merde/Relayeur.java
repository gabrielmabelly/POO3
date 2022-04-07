package merde;

import java.util.Iterator;

public class Relayeur extends Thread {

	volatile int distanceParcourue;
	int rang;
	Relayeur pred;

	
	public Relayeur(int rang, Relayeur pred) {
		super();
		this.distanceParcourue = 0;
		this.rang = rang;
		this.pred = pred;
	}



	@Override
	public void run() {
		if (this.pred!=null) {
			while (pred.distanceParcourue<980) {
			//System.out.println("["+this.getName()+"] j'attends");
			}
		}
		for (int i = 1; i <= 1000; i++) {
			distanceParcourue++;
			System.out.println("["+this.getName()+"] coureur de rang " + this.rang + " et j'ai parcouru " + i + " m");			
		}
		
		
	}
	
}