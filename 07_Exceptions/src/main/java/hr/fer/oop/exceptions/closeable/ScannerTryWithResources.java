package hr.fer.oop.exceptions.closeable;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.Scanner;

public class ScannerTryWithResources {
	public static void main(String[] args) {			
		Path path = Paths.get("src/main/resources/dates.txt");		
		try (Scanner  s =  new Scanner(path)) {			
			String firstLine = s.nextLine();		
			LocalDate date = LocalDate.parse(firstLine);
			System.out.format("Day in year: %d%n", date.getDayOfYear());			
		} 
		catch (IOException e) {
			e.printStackTrace();
		}		
	}

}
