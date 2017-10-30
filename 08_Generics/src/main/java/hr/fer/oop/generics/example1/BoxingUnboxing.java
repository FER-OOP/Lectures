package hr.fer.oop.generics.example1;

public class BoxingUnboxing {

	public static void main(String[] args) {				
		IntWrapper number = new IntWrapper(5); // IntWrapper number = new IntWrapper(Integer.valueOf(5)); 
		System.err.println(number);
		
		number.setValue(number.getValue()+1);
		// Integer + int => unboxing => number.setValue(number.getValue().intValue()+1); 
		// Sada: int + int => int as argument => number.setValue(Integer.valueOf(number.getValue().intValue()+1)); 

		System.err.println(number);
		
		DoubleWrapper doubleNumber = new DoubleWrapper(2.5);
		System.err.println(doubleNumber);
		doubleNumber.setValue(doubleNumber.getValue()+1);
		System.err.println(doubleNumber);		
	}		
}
