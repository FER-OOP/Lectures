package hr.fer.oop.exceptions.example6;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class MainThrows {

	public static void main(String[] args) throws IOException {		
		Path filename = Paths.get("C:/temp", "nofile.txt");
		List<String> list = Files.readAllLines(filename);
		for(String line : list){
			System.out.println(line);
		}
		
	}	
}
