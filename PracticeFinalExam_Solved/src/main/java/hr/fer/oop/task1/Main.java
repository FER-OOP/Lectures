package hr.fer.oop.task1;

import java.util.Random;

public class Main {
	public static void main(String[] args) {
		Random r = new Random();
		int noOfEmployees = 5;
		SharedData data = new SharedData(noOfEmployees);

		OnAir onAir = new OnAir(data);
		onAir.setDaemon(true);
		onAir.start();

		for (int i = 0; i < noOfEmployees; i++) {
			Employee d = new Employee(data, i);
			d.setDaemon(true);
			d.start();
		}

		int i = 0;
		while (!data.isGameOver()) {
			++i;
			String player = Integer.toString(i);
			try {
				new Thread(() -> {
					try {
						System.out.format("Igrač %s stvoren %n", player);
						data.getQueue().put(player);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}).start();
				Thread.sleep(r.nextInt(2000));
			} catch (InterruptedException e) {
			}
		}

	}
}
