package hr.fer.oop.threads.unsafe;

public class Point {
	private int x, y;

	public Point() {
	}

	public void setPoint(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public String toString() {
		return "(" + x + "," + y + ")";
	}
}
