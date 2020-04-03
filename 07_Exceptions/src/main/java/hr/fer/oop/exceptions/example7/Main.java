package hr.fer.oop.exceptions.example7;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {		
		Path path = Paths.get("src/main/resources/dates.txt");				
		try {
			Scanner s = new Scanner(path);
			String firstLine = s.nextLine();		
			System.out.println(firstLine);		
			s.close();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}						
	}	
}