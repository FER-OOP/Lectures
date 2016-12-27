package hr.fer.oop.threads.example5;

public class Point {
	private int x, y;

	public Point() {
	}

	public synchronized void setPoint(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public synchronized String toString() {
		return "(" + x + "," + y + ")";
	}
}
