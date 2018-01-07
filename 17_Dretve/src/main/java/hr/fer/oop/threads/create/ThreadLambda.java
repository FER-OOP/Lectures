package hr.fer.oop.threads.create;

public class ThreadLambda {
	public static void main(String[] args) {
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("broj " + i);
            }
            System.out.println("Gotovo brojenje");
        }).start();
    }
}
