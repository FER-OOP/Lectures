package hr.fer.oop.homework_01_02.lotto;

import java.util.Arrays;
import java.util.Random;

public class Lotto {

	public static int[] drawA(int count, int max) {		
		boolean[] drawn = new boolean[max];
		int[] numbers = new int[count]; 
		while(count > 0) {
			int num = (int) (Math.random() * max); 
			if (!drawn[num]) {
				--count;
				drawn[num] = true;
				numbers[count] = num + 1;				
 			}
		}
		Arrays.sort(numbers);
		return numbers;
	}
	
	public static int[] drawB(int count, int max) { //variant with Random, and next int				
		boolean[] drawn = new boolean[max];
		int[] numbers = new int[count]; 
		Random r = new Random();
		while(count > 0) {
			int num = r.nextInt(max); 
			if (!drawn[num]) {
				--count;
				drawn[num] = true;
				numbers[count] = num + 1;				
 			}
		}
		Arrays.sort(numbers);
		return numbers;
	}
}
