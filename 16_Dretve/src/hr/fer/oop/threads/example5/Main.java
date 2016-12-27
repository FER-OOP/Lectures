package hr.fer.oop.threads.example5;

public class Main {
	public static void main(String[] args) {
		Point p = new Point();
		new ThreadSetter(p, 0).start();
		new ThreadSetter(p, 10).start();
	}
}
