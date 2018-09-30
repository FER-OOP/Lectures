package hr.fer.oop.introduction;
/**
 * @author OOP course
 * @version 1.0
 */
public class TaylorSeriesSum {
	/**
	 * This method is called once the program is run.   
	 * Arguments are described below
	 * @param args Command line arguments.
	 */	
	public static void main(String[] args) {
		if(args.length != 1) {
			System.err.println("A program needs argument x for e^x!");
			System.exit(1);
		}
		double x = Double.parseDouble(args[0]); 
		System.out.println("Calculating e^x..."); 
		double sum = ePowerX(x);
		System.out.format("e ^ %.2f = %.2f%n", x, sum);
	}
	/**
	 * Calculates e^x for Taylor series, according to formula:
	 * e^x=1+x+(x^2/(2!))+(x^3/(3!))+(x^4/(4!))+...
	 * @param number argument of function e^x 
	 * @return function result for the point x=number calculated as sum of first 10 numbers in Taylor series.
	 */
	public static double ePowerX(double x) { 
		double sum = 0.0;
		double power = 1.0; 
		double factorial = 1.0;
		sum += 1.0;
		for(int i = 1; i < 10; i++) {  
			power = power * x; 
			factorial = factorial * i;
			sum += power/factorial;
		}
		return sum;
	}
}
