package hr.fer.oop.homework_09.t02;

public class Pair<T> {
	private final T first;
	private final T second;
	public Pair(T first, T second) {
		this.first = first;
		this.second = second;
		
	}
	public T getFirst() {
		return first;
	}	
	public T getSecond() {
		return second;
	}	
}
