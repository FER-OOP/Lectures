package hr.fer.oop.exceptions.example4;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class ScannerWithoutTryCatch {		
	public static void main(String[] args) {
		String input = "2017-13-23"; //bad date...
		Scanner s = new Scanner(input);		
		String line = s.nextLine();
		LocalDate date = LocalDate.parse(line); //exception due to bad date
		System.out.println(date);
		System.out.format("Day in year: %d%n", date.getDayOfYear());
		
		System.out.println("Closing scanner");
		s.close();	//never gets called!		
	}
}
