package hr.fer.oop.simple;
import hr.fer.oop.util.Taylor;
public class CalculateE_v2 {
	
	public static void main(String[] args) {
		double e = Taylor.ePowerX(1);
		System.out.printf("e = %.6f%n", e);
        double diff = Math.abs(Math.E - e);
        System.out.printf("diff = %g%n", diff);
	}	
}
