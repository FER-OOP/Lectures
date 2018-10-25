package hr.fer.oop.generics.example1;

public class BoxingUnboxing {

	public static void main(String[] args) {
		IntegerPoint point = new IntegerPoint(10, 20);
		// IntegerPoint point = 
		//	  new IntegerPoint(Integer.valueOf(10), Integer.valueOf(20)); 
		System.out.println(point);
		
		int sum = point.getX() + point.getY();
		// Integer + Integer => 
		// unboxing => point.getX().intValue() + point.getY().intValue(); 		

		System.out.println(sum);
	
	}		
}
