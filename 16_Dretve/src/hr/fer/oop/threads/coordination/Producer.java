package hr.fer.oop.threads.coordination;

import java.util.concurrent.BlockingQueue;

public class Producer extends Thread {
	private BlockingQueue<Integer> queue;
	private int id;

	public Producer(BlockingQueue<Integer> queue, int id) {
		this.queue = queue;
		this.id = id;
	}

	public void run() {
		for (int i = 0; i < 10; i++) {
			try {
				this.queue.put(i);
			} catch (InterruptedException e1) {
			}
			System.out.println("Producer " + id + " stavio: " + i);
			try {
				Thread.sleep((int) (Math.random() * 100));
			} catch (InterruptedException e) {
			}
		}
	}
}
