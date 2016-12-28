package hr.fer.oop.threads.example7;

import java.util.concurrent.BlockingQueue;

public class Consumer extends Thread {
	private BlockingQueue<Integer> queue;
	private int id;

	public Consumer(BlockingQueue<Integer> queue, int id) {
		this.queue = queue;
		this.id = id;
	}

	public void run() {
		Integer n = null;
		for(int i = 0; i<10; i++) {
			try {
				n = queue.take();
			} catch (InterruptedException e) {
				e.printStackTrace();
				n = null;
			}
			System.out.println("Consumer " + id + " uzeo: " + n);
		}
	}
}
