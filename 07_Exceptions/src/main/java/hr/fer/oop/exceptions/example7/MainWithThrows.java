package hr.fer.oop.exceptions.example7;


import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class MainWithThrows {

	public static void main(String[] args) throws IOException {		
		Path path = Paths.get("src/main/resources/dates.txt");						
		Scanner s = new Scanner(path);
		String firstLine = s.nextLine();		
		System.out.println(firstLine);		
		s.close();			
	}	
}