package hr.fer.oop.boxing_unboxing;

public class BoxingUnboxing {

	public static void main(String[] args) {
		int a = 10;
		Integer x = Integer.valueOf(a); //boxing
		int c = x.intValue(); //unboxing
		int y = 20;
		Integer z = x  + y;
		// => (auto)unboxing x: x.intValue() + y  => produces int 		
		// => (auto)boxing to z Integer.valueof(x.intValue() + y);
		
		System.out.println("" + x + " + " + y + " = " + z);
		// => uses StringBuilder to append strings and primitive values
	
	}		
}
