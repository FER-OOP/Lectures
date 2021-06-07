package hr.fer.oop.homework_13_e4;

public class Calculator {
	public static double[] toPolar(double real, double imag) {
		double result[] = new double[2];
		result[0] = Math.sqrt(Math.pow(real, 2)+ Math.pow(imag, 2));
		result[1] = Math.toDegrees(Math.atan2(imag, real));
		return result;
	}
	
	public static double[] toRectg(double module, double angle) {
		double result[] = new double[2];
		angle = Math.toRadians(angle);
		result[0] = module*Math.cos(angle);
		result[1] = module*Math.sin(angle);
		return result;
	}
}
