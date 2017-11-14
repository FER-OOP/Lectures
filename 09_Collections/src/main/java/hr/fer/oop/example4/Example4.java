package hr.fer.oop.example4;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import hr.fer.oop.lists.BelowLimit;

public class Example4 {

	
	
	public static void main(String[] args) throws IOException {

		List<Double> numbers = new ArrayList<>();

		// Select here source for numbers:
		NumberSource source = new KeyboardNumberSource();
		//NumberSource source = new FileNumberSource(Paths.get("numbers.txt"));
		
		while(source.hasMoreNumbers()) {
				numbers.add(source.getNumber());
		}
		
		if(!numbers.isEmpty()) {
			double avg = calcAverage(numbers);
			double limit = avg*1.2;
			
			//remove all lower than limit
			numbers.removeIf(new BelowLimit(limit));
			//sort remaining elements
			Collections.sort(numbers);
			
			System.out.format("Writing numbers 20%% larger than average (%.2f)%n", avg);
			for(double number : numbers) {
				System.out.println(number);			
			}
		}
	}

	private static double calcAverage(List<Double> numbers) {
		double sum = 0;
		for(double d : numbers) {
			sum += d;
		}
		return sum/numbers.size();
	}

}
