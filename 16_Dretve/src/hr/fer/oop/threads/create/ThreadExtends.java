package hr.fer.oop.threads.create;

public class ThreadExtends extends Thread {
	@Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("broj " + i);
        }
        System.out.println("Gotovo brojanje");
    }

    public static void main(String[] args) {
        new ThreadExtends().start();
        new ThreadExtends().start();
    }
}
