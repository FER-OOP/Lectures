package hr.fer.oop.simple;
import hr.fer.oop.util.Taylor;
public class CalculateEPowerX {
	
	public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("The program needs an integer value x to calculate e^x.");
            System.exit(1);
        }
        int x = Integer.parseInt(args[0]);
		double result = Taylor.ePowerX(x);
		System.out.printf("e^%d = %.6f%n", x, result);
        double diff = Math.abs(Math.pow(Math.E, x) - result);
        System.out.printf("diff = %g%n", diff);
	}	
}
