package hr.fer.oop.threads.example1;

public class ThreadAnonymous {
	public static void main(String[] args) {
        Thread thread = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    System.out.println("broj " + i);
                }
                System.out.println("Gotovo brojenje");
            }
        };
        thread.start();
    }
}
