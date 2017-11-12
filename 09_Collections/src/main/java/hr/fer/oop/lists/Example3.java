package hr.fer.oop.lists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class Example3 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		List<Double> numbers = new ArrayList<>();
		
		System.out.println("Enter numbers (quit for end):");
		while(true) {
			if(scanner.hasNextDouble()) {
				numbers.add(scanner.nextDouble());
				continue;
			}
			String value = scanner.next();
			if("quit".equals(value)) {
				break;
			}
			System.out.println("Unexpected input: " + value);
		}
		
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
		
		scanner.close();
	}

	private static double calcAverage(List<Double> numbers) {
		double sum = 0;
		for(double d : numbers) {
			sum += d;
		}
		return sum/numbers.size();
	}

}
