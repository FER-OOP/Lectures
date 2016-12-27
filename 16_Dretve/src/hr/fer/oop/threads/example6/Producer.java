package hr.fer.oop.threads.example6;

public class Producer extends Thread {
	private Storage s;
	private int num;

	public Producer(Storage s, int i) {
		this.s = s;
		num = i;
	}

	public void run() {
		for (int i = 0; i < 10; i++) {
			s.put(i);
			System.out.println("Producer " + num + " stavio: " + i);
			try {
				sleep((int) (Math.random() * 100));
			} catch (InterruptedException e) {
			}
		}
	}
}
