package hr.fer.oop.exceptions.example8;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.Scanner;

public class ScannerTryCatchFinally {
	public static void main(String[] args) {			
		Path path = Paths.get("src/main/resources/dates.txt");
		Scanner s = null;
		try {
			s = new Scanner(path);
			String firstLine = s.nextLine();		
			LocalDate date = LocalDate.parse(firstLine);
			System.out.format("Day in year: %d%n", date.getDayOfYear());			
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			System.out.println("This code is always run");
			if (s != null) 	s.close();
		}
	}

}
