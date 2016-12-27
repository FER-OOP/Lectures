package hr.fer.oop.threads.example6;

public class Main {
	public static void main(String[] args) {
		Storage s = new Storage();
		Producer p = new Producer(s, 1);
		Consumer c = new Consumer(s, 1);

		p.start();
		c.start();
	}
}
