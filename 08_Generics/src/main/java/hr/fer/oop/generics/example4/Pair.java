package hr.fer.oop.generics.example4;

public class Pair<T> {
	private T first;
	private T second;

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

	@Override
	public String toString() {
		return "(" + first + ", " + second + ")";
	}
}
