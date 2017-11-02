package hr.fer.oop.generics.example2;

public class Main {
	public static void main(String[] args) {
		Wrapper<Integer> iNumber = new Wrapper<>(5);
		Wrapper<Double> dNumber = new Wrapper<>(15.0);			
		
		System.out.println("Before: " + iNumber+", "+dNumber);
		updateRandomlyInt(iNumber);
		updateRandomlyDouble(dNumber);
		// Will compiler catch the error if we uncomment
		// next line?
		//updateRandomlyDouble(iNumber);
		System.out.println("After: " + iNumber+", "+dNumber);
		
		// If we create a wrapper around String, compiler
		// will allow us to call String methods on wrapped
		// object because it knows that the object is is an 
		// instance of string.
		Wrapper<String> someText = new Wrapper<>("Hi there!");
		System.out.println(someText.getValue().length());

		// The next line is compile time error:
		// Integer i = (Integer)someText.getValue();
		
		// But you can force compiler to forget types:
		Integer i = (Integer)(Object)someText.getValue();
		// so now the following line will compile, but
		// will never execute since the previous one will
		// throw an exception...
		System.out.println(i.doubleValue());
	}

	private static void updateRandomlyInt(Wrapper<Integer> number) {
		if(Math.random() < 0.5) {
			number.setValue(number.getValue()+1);
		}
	}

	private static void updateRandomlyDouble(Wrapper<Double> number) {
		number.setValue(number.getValue()+Math.random());
	}
}
