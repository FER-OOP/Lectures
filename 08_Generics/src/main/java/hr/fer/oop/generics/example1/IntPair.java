package hr.fer.oop.generics.example1;

public class IntPair {
	private int first;
	private int second;
	
	public IntPair(int x, int y) {
		this.first = x;
		this.second = y;
	}

	public int getFirst() {
		return first;
	}

	public int getSecond() {
		return second;
	}

	@Override
	public String toString() {
		return "(" + first + ", " + second + ")";
	}		
}
