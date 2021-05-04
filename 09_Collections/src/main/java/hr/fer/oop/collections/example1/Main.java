package hr.fer.oop.collections.example1;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Integer> numbers = Loader.loadNonNegativeNumbers(sc);
						
		if(!numbers.isEmpty()) {
			double avg = calcAverage(numbers);
						
			Predicate<Number> belowAverage = new BelowThreshold(avg);
			numbers.removeIf(belowAverage);
						
			Collections.sort(numbers);
			
			System.out.format("Numbers >= %.2f %n", avg);
			for(int number : numbers) {
				System.out.println(number);			
			}			
		}				
	}

	private static double calcAverage(Collection<Integer> numbers) {
		int sum = 0;
		for(int d : numbers) {
			sum += d;
		}
		return (double) sum/numbers.size();
	}

}
