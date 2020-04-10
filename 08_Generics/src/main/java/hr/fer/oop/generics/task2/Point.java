package hr.fer.oop.generics.task2;

public class Point<T extends Number> extends Pair<T, T> {

	public Point(T first, T second) {
		super(first, second);		
	}
	
	public T getX() {
		return getFirst();
	}
	
	public T getY() {
		return getSecond();
	}	
}
