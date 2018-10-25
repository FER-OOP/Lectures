package hr.fer.oop.example3;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

public class Main {

	public static void main(String[] args) {
		
		List<Double> numbers = Loader.loadNumbers();
						
		if(!numbers.isEmpty()) {
			double avg = calcAverage(numbers);
			double limit = avg*1.2;
			
			//remove all lower than limit
			Predicate<Double> belowLimit = new BelowLimit(limit);
			numbers.removeIf(belowLimit);
			
			//sort remaining elements
			Collections.sort(numbers);
			
			System.out.format("Writing numbers 20%% larger than average (%.2f)%n", avg);
			for(double number : numbers) {
				System.out.println(number);			
			}
			
		}				
	}

	private static double calcAverage(Collection<Double> numbers) {
		double sum = 0;
		for(double d : numbers) {
			sum += d;
		}
		return sum/numbers.size();
	}

}
