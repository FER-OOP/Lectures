package hr.fer.oop.classes;

import hr.fer.oop.classes.operations.PointOperations;

public class Main {
	
	public static void main(String[] args) {
		Point a = new Point(1, 1);
		Point b = new Point(-2, 3);
		Point c = new Point(-3, -3);
		Point d = new Point(4, -2);
		
		Point mostDistantPoint = PointOperations.pointMostDistantFromOrigin(a, b, c, d);
		System.out.println(mostDistantPoint);
	}
}
