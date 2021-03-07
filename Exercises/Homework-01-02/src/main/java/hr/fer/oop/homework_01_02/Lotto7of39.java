package hr.fer.oop.homework_01_02;

public class Lotto7of39 {

	public static void main(String[] args) {		
		boolean[] numbers = new boolean[49];
		for(int i=0; i < 7; ) {
			int num = (int) (Math.random() * 49); //num is in [0, 48] 
			if (!numbers[num]) {
				numbers[num] = true;
				++i;
 			}
		}
		
		for(int i=0; i<numbers.length ; i++) {
			if (numbers[i]) {
				System.out.printf("%d ", i + 1);
			}
		}
		System.out.println();
	}
}
