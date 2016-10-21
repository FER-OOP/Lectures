package hr.fer.oop.generics.example3;

public class PointMain {
	public static void main(String[] args) {
		Point<Integer> iNumber = new Point<>(5, 5);
		Point<Double> dNumber = new Point<>(15.0, 10.0);
		
		iNumber.printWith(dNumber);
		iNumber.printWith("OOP");
		
		iNumber.printWithPoint(dNumber);
		iNumber.printWithPoint(iNumber);
		//iNumber.printWithPoint("OOP"); //compile error
	}
}
