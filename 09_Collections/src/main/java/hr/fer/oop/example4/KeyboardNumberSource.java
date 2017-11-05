package hr.fer.oop.example4;

import java.util.Scanner;

public class KeyboardNumberSource implements NumberSource {
	private Scanner scanner = new Scanner(System.in);
	private double number;
	private boolean numberSet = false;
	private boolean done = false;
	
	@Override
	public boolean hasMoreNumbers() {
		if(done) return false;
		if(numberSet) return true;//number already ready
		while(true) {
			if(scanner.hasNextDouble()) {
				number = scanner.nextDouble();
				numberSet = true;
				return true;
			}
			String value = scanner.next();
			if("quit".equals(value)) {
				done = true;
				return false;
			}
			System.out.println("Unexpected input: " + value);
		}
	}
	
	@Override
	public double getNumber() {
		if(!hasMoreNumbers()) throw new IllegalStateException("No more numbers!");
		numberSet = false;
		return number;
	}
}