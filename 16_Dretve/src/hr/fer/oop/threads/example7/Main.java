package hr.fer.oop.threads.example7;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Main {
	public static void main(String[] args) {
		//velicina reda ogranicena na 5 elemenata
		BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(5);
		Producer p = new Producer(queue, 1);
		Consumer c = new Consumer(queue, 1);

		p.start();
		c.start();
	}
}
