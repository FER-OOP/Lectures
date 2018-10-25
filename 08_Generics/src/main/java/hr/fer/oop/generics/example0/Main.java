package hr.fer.oop.generics.example0;

public class Main {

	public static void main(String[] args) {
		Integer number = new Integer(5); //Since Java9 Integer.valueOf(5) should be used
		System.out.println("Before: " + number);
		updateRandomly(number);
		System.out.println("After: " + number); //discuss the result
	}
	
	private static void updateRandomly(Integer number) {
		if(Math.random() < 0.5) {
			number = Integer.valueOf(number.intValue() + 1);
		}
	}

}
