package hr.fer.oop.generics.example1;

public class StringPair {
	private String first;
	private String second;
	
	public StringPair(String x, String y) {
		this.first = x;
		this.second = y;
	}

	public String getFirst() {
		return first;
	}

	public String getSecond() {
		return second;
	}

	@Override
	public String toString() {
		return "(" + first + ", " + second + ")";
	}		
}
