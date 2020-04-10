package hr.fer.oop.generics.example3;

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

	public <V> void printWith(V another) {
		System.out.format("first: %s second %s %n", this.toString(), another.toString());
	}

	// public <V> void printWithPair(Pair<V> another){
	public void printWithPair(Pair<?> another) {
		System.out.format("first: %s second %s,%s %n", 
				this.toString(), 
				another.getFirst().toString(), 
				another.getSecond().toString());
	}	
}
