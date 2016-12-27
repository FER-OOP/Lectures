package hr.fer.oop.threads.example2;

public class NamedThreadWithSleep {
	public static void main(String[] args) {
		Runnable runnable = () -> {
			for (int i = 0; i < 5; i++) {
	            System.out.println("Dretva " + Thread.currentThread().getName() + " : i = " + i);
	            try {
	                Thread.sleep( (int) (Math.random() * 1000));
	            }
	            catch (InterruptedException ie) {
	            }
			}
			System.out.println("Gotova dretva " + Thread.currentThread().getName());
		};

		new Thread(runnable, "A").start();
		new Thread(runnable, "B").start();
	}
}
