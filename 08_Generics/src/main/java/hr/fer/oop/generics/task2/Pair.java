package hr.fer.oop.generics.task2;

public class Pair<T, U> {
	private T first;
	private U second;

	public Pair(T first, U second) {
		this.first = first;
		this.second = second;
	}

	public T getFirst() {
		return first;
	}
	
	public void setFirst(T value) {
		first = value;
	}

	public U getSecond() {
		return second;
	}
	
	public void setSecond(U value) {
		second = value;
	}

	@Override
	public String toString() {
		return "(" + first + ", " + second + ")";
	}
}
