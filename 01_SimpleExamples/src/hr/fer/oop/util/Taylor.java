package hr.fer.oop.util;

public class Taylor {	
	/**
	 * Calculates e^x for Taylor series, according to formula:
	 * e^x=1+x+(x^2/(2!))+(x^3/(3!))+(x^4/(4!))+...
	 * @param x argument of function e^x 
	 * @return e^x calculated as sum of first 10 numbers in Taylor series.
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
