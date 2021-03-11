package hr.fer.oop.homework_01_02;


public class SolveEquationArgs {

	public static void main(String[] args) {		
		if (args.length == 3) {
			double a = Double.parseDouble(args[0]);
			double b = Double.parseDouble(args[1]);
			double c = Double.parseDouble(args[2]);
			
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
		else {
			System.out.println("Program need arguments for a, b, and c in ax^2 + bx + c = 0");						
		}		
	}

}
