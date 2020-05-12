package hr.fer.oop.lab5.task1;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

public class Main {

	public static void main(String[] args) {
		Path racuni = Paths.get("./src/main/resources/racuni"); 
		
		try {			
			
			Files.walkFileTree(racuni, visitor);			
			
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}					
	}
}
