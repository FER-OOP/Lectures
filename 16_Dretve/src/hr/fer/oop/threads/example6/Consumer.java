package hr.fer.oop.threads.example6;

public class Consumer extends Thread {
	private Storage s;
	private int num;

	public Consumer(Storage s, int i) {
		this.s = s;
		num = i;
	}

	public void run() {
		int n = 0;
		for (int i = 0; i < 10; i++) {
			n = s.get();
			System.out.println("Consumer " + num + " uzeo: " + n);
		}
	}
}
