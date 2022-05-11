package hr.fer.oop.task3;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class PrepareBinaryFile {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		String filename = "src/main/resources/years.dat";
		try(OutputStream output = Files.newOutputStream(Path.of(filename), StandardOpenOption.CREATE)) {
			for(int i=1; i<=10; i++) {
				output.write(i);
			}
		}
	}

}
