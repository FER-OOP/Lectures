package hr.fer.oop.threads.example7;

import java.util.concurrent.BlockingQueue;

public class Producer extends Thread {
	private BlockingQueue<Integer> queue;
	private int num;

	public Producer(BlockingQueue<Integer> queue, int i) {
		this.queue = queue;
		num = i;
	}

	public void run() {
		for (int i = 0; i < 10; i++) {
			try {
				this.queue.put(i);
			} catch (InterruptedException e1) {
			}
			System.out.println("Producer " + num + " stavio: " + i);
			try {
				sleep((int) (Math.random() * 100));
			} catch (InterruptedException e) {
			}
		}
	}
}
