package hr.fer.oop.threads.example7;

import java.util.concurrent.BlockingQueue;

public class Consumer extends Thread {
	private BlockingQueue<Integer> queue;
	private int num;

	public Consumer(BlockingQueue<Integer> queue, int i) {
		this.queue = queue;
		num = i;
	}

	public void run() {
		Integer n = 0; int i = 0;
		while (i < 10) {
			if(!queue.isEmpty()){
				n = queue.remove();
				i++;
				System.out.println("Consumer " + num + " uzeo: " + n);
			}
			try {
				//faktor 1.5 za prosjecno sporiji pokusaj konzumacije
				Thread.sleep((int) (Math.random() * 100 * 1.5));
			} catch (InterruptedException e) {
			}
		}
	}
}
