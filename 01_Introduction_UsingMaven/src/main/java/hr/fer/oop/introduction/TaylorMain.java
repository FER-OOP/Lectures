package hr.fer.oop.introduction;
/**
 * @author OOP course
 * @version 1.0
 */
public class TaylorMain {
	
	public static void main(String[] args) {
		if(args.length != 1) {
			System.err.println("A program needs argument x for e^x!");
			System.exit(1);
		}
		double x = Double.parseDouble(args[0]); 
		System.out.println("Calculating e^x..."); 
		double sum = Taylor.ePowerX(x);
		System.out.format("e ^ %.2f = %.2f%n", x, sum);
	}	
}
