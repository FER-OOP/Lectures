package hr.fer.oop.lists;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class Example3 {

	public static void main(String[] args) {
		
		List<Double> numbers = LoadNumbers();
						
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

	private static List<Double> LoadNumbers() {
		List<Double> numbers = new LinkedList<>();
		try(Scanner scanner = new Scanner(System.in)){					
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
		}
		return numbers;
	}

	private static double calcAverage(Collection<Double> numbers) {
		double sum = 0;
		for(double d : numbers) {
			sum += d;
		}
		return sum/numbers.size();
	}

}
