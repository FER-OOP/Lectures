package hr.fer.oop.objectcreation;

import java.util.Scanner;

public class ReadFromStandardInput {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Please enter an integer number");
		int x = sc.nextInt();
		System.out.println("Entered: " + x);
		
		System.out.println("Now, enter a floating point number");
		double y = sc.nextDouble();
		System.out.println("Entered: " + y);
		
		System.out.println("And now enter several lines. Enter Q or q to quit.");		
		while(sc.hasNextLine()) {
			String line = sc.nextLine();
			if (line.equalsIgnoreCase("Q"))
				break;
			System.out.println(line);
		}		
	}
}
