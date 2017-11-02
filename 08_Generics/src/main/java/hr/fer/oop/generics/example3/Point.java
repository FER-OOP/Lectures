package hr.fer.oop.generics.example3;

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

	public <V> void printWith(V another) {
		System.out.format("first: %s second %s %n", this.toString(), another.toString());
	}

	// public <V> void printWithPoint(Point<V> another){
	public void printWithPoint(Point<?> another) {
		System.out.format("first: %s second %s,%s %n", 
				this.toString(), 
				another.getX().toString(), 
				another.getY().toString());
	}
}
