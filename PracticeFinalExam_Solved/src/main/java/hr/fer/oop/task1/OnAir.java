package hr.fer.oop.task1;

import java.util.Random;

public class OnAir extends Thread {
	private SharedData data;

	public OnAir(SharedData data) {
		this.data = data;		
	}

	public void run() {
		Random r = new Random();
		while(!data.isGameOver()){		
			try {
				String player = data.getAirQueue().take();
				System.out.format("-------------->Igrač u eteru %s%n",  player);
				//igrač razmišlja
				Thread.sleep(r.nextInt(10000));
				//i odgovara na pitanje
				if (r.nextInt(10) == 9 ){
					data.setGameOver(true);					
					System.out.format("IGRAČ %s OSVOJIO NAGRADU%n",  player);					
				}
				else{
					System.out.format("------------------>Igrač %s nije točno odgovorio na pitanje%n",  player);
				}
			}			
			catch (InterruptedException e1) {
			}					
		}
	}
}
