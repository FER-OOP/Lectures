package hr.fer.oop.homework_01_02;

public class PiLeibnitz {

	public static void main(String[] args) {		
		double sum = 0;	
		int nextPowerOf10 = 10;
		for(int i=0; i<=1000000; i++) {
			if (i % 2 == 0)
				sum += 1. / (2 * i + 1);
			else 
				sum -= 1. / (2 * i + 1);
			
			if (i == nextPowerOf10) {
				System.out.printf("i = %d , pi = %.10f %n", i, 4 * sum);
				nextPowerOf10 *= 10;
			}
		}
	}
}
