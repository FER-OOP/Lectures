package hr.fer.oop.homework_01_02;

public class PiEuler {

	public static void main(String[] args) {		
		double sum = 0;
		int first5 = (int) (Math.PI * 1e5);
		int calc5 = 0;		
		int i=0;
		while(first5 != calc5) {
			++i;
			sum += 1./((double)i*i);
			calc5 = (int) (1e5 * Math.sqrt(6 * sum));			
		}
		System.out.printf("Pi after %d steps is %f%n", i, Math.sqrt(6. * sum));					
	}
}
