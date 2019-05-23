package hr.fer.oop.zad1;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class Compute {

	public static void main(String[] args) throws UnsupportedEncodingException, FileNotFoundException, IOException {
		if (args.length <= 1) {
			throw new IllegalArgumentException();
		}
		
		//CMD arguments: .\files .pdf .pptx
		List<String> extensions = Arrays.asList(Arrays.copyOfRange(args, 1, args.length));
		MyFileVisitor visitor = new MyFileVisitor(extensions);
				
		try { 
			Files.walkFileTree(Paths.get(args[0]), visitor);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("Ukupna veličina: " + visitor.getTotalSum()/1024/1024 + " MB");
		
		for (Item d : visitor.getTenBiggest()) {
			System.out.println(d.getName() + ": " + d.getSize());
		}

	}

}
