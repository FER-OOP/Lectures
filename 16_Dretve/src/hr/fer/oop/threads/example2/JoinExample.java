package hr.fer.oop.threads.example2;

public class JoinExample {

	public static void main(String[] args) {
		Runnable runnable = () -> {
			for (int i = 0; i < 5; i++) {
				System.out.println("Nit " + Thread.currentThread().getName()
						+ " : i = " + i);
				try {
					Thread.sleep((int) (Math.random() * 1000));
				} catch (InterruptedException ie) {
				}
			}
			System.out
					.println("Gotova nit " + Thread.currentThread().getName());
		};
		
		Thread thread = new Thread(runnable, "Brojac");
		thread.start();

		try {
			thread.join();
		} catch (InterruptedException e) {
		}
		
		System.out.println("Main je gotov");
	}

}
