package hr.fer.oop.exceptions.example6;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		try{
			Path filename = Paths.get("C:/temp", "nofile.txt");
			List<String> list = Files.readAllLines(filename);
			for(String line : list){
				System.out.println(line);
			}
		}
		catch(IOException exc){
			System.err.println(exc);
		}
	}	
}
