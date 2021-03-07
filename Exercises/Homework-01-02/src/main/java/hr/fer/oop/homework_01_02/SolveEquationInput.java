package hr.fer.oop.homework_01_02;

import java.util.Scanner;

public class SolveEquationInput {

	public static void main(String[] args) {		
		Scanner sc = new Scanner(System.in);
		System.out.println("Please provide values for a, b, and c in ax^2 + bx = c");
		double a = sc.nextDouble();
		double b = sc.nextDouble();
		double c = sc.nextDouble();
			
		double d = b * b - 4 * a * c;
		if (d > 0) {
			double x1 = (-b + Math.sqrt(d)) / (2*a);
			double x2 = (-b - Math.sqrt(d)) / (2*a);
			System.out.printf("x1 = %g, x2 = %g %n", x1, x2);
		}
		else if (d == 0) {
			double x = -b / (2*a);				
			System.out.printf("x = %g %n", x);
		}
		else {
			System.out.println("No solution available in R");
		}		
	}

}
