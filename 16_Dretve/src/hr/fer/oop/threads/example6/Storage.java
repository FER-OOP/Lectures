package hr.fer.oop.threads.example6;

public class Storage {
	private int num;
	private boolean bEmpty = true;

	public synchronized int get() {
		while (bEmpty == true) {
			try {
				wait();
			} catch (InterruptedException e) {
			}
		}
		bEmpty = true;
		notifyAll();
		return num;
	}

	public synchronized void put(int i) {
		while (bEmpty == false) {
			try {
				wait();
			} catch (InterruptedException e) {
			}
		}
		num = i;
		bEmpty = false;
		notifyAll();
	}
}
