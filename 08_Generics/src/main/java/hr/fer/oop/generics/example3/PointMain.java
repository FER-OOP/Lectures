package hr.fer.oop.generics.example3;

public class PointMain {
	public static void main(String[] args) {
		Point<Integer> iPoint = new Point<>(5, 5);
		Point<Double> dPoint = new Point<>(15.0, 10.0);
		
		iPoint.printWith(dPoint);
		iPoint.printWith("OOP");
		
		iPoint.printWithPoint(dPoint);
		iPoint.printWithPoint(iPoint);
		//iPoint.printWithPoint("OOP"); //compile error
	}
}
