package hr.fer.oop.example3;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Loader {
	public static List<Double> loadNumbers() {
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
}
