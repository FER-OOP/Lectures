package hr.fer.oop.threads.create;

public class ThreadAnonymous {
	public static void main(String[] args) {
        Thread thread = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    System.out.println("broj " + i);
                }
                System.out.println("Gotovo brojanje");
            }
        };
        thread.start();
    }
}
