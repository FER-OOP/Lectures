package hr.fer.oop.generics.example2;

public class Point<T> {
	private T x;
	private T y;
	
	public Point(T x, T y) {
		this.x = x;
		this.y = y;
	}

	public T getX() {
		return x;
	}

	public T getY() {
		return y;
	}

	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}
}
