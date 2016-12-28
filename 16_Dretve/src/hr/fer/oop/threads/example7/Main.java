package hr.fer.oop.threads.example7;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Main {
	public static void main(String[] args) {
		//velicina reda ogranicena na 1 element
		BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(1);
		Producer p = new Producer(queue, 10);
		Consumer c = new Consumer(queue, 20);

		p.start();
		c.start();
	}
}
