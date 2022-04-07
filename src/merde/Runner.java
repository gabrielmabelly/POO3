package merde;

public class Runner implements Runnable {

	volatile int distanceParcourue;
	int rang;
	Runner pred;

	
	public Runner(int rang, Runner pred) {
		super();
		this.distanceParcourue = 0;
		this.rang = rang;
		this.pred = pred;
	}



	@Override
	public void run() {
		if (this.pred!=null) {
			while (pred.distanceParcourue<480) {
			//System.out.println("["+this.getName()+"] j'attends");
			}
		}
		for (int i = 1; i <= 500; i++) {
			distanceParcourue++;
			System.out.println("["+Thread.currentThread().getName()+"] coureur de rang " + this.rang + " et j'ai parcouru " + i + " m");			
		}
		
		
	}
	
}
