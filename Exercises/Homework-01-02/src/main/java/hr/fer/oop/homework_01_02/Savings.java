package hr.fer.oop.homework_01_02;


public class Savings {

	public static void main(String[] args) {		
		if (args.length == 3) {
			double savings = Double.parseDouble(args[0]);
			double interestRate = Double.parseDouble(args[1]);
			int years = Integer.parseInt(args[2]);
			
			System.out.println("|--Year--|---Savings---|");			
			for(int i=0; i<years ; i++) {
				savings *= (1 + interestRate);
				System.out.printf("|%5d   | %10.2f  | %n", i, savings);
			}
			System.out.println("|--------|-------------|");
		}
		else {
			System.out.println("Program need arguments for initial capital (savings), interest rate, and number of years ");						
		}		
	}

}
