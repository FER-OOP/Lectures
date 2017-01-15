package hr.fer.oop.task1;

import java.util.Random;

public class Employee extends Thread {
	private SharedData data;	
	private int num;

	public Employee(SharedData data, int i) {
		this.data = data;		
		num = i;
	}

	public void run() {
		Random r = new Random();
		while (!data.isGameOver()) {
			try {				
				String player = data.getQueue().take();
				if (data.isGameOver()) break;
				System.out.format("Djelatnik %d preuzeo igrača %s (rbr: %d) %n", num, player, data.nextId());
				// igrač razmišlja
				Thread.sleep(r.nextInt(5000));
				// i odgovara na pitanje
				
				if (data.isGameOver()) break;//igra završena, svejedno što je odgovorio
				if (r.nextBoolean()) {
					System.out.format("--->Igrač %s čeka uključenje u eter%n", player);
					// igrač čeka za u eter
					Thread t = new Thread(() -> {
						try {
							data.getAirQueue().put(player);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					});
					t.setDaemon(true);
					t.start();
				} else {
					System.out.format("Igrač %s nije točno odgovorio na kvalifikacijsko pitanje%n", player);							
				}
				
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		}
	}
}
