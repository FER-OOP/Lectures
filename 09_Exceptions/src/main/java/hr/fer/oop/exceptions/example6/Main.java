package hr.fer.oop.exceptions.example6;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

	public static void main(String[] args) {				
		try{			
			Path filename = Paths.get("nofile.txt");
			long size = Files.size(filename);
			System.out.println("Filesize : " + size);
		}
		catch(IOException exc){
			System.err.println(exc);
		}
	}	
}
