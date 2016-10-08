package hr.fer.oop.example4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileNumberSource implements NumberSource {
	private double number;
	private boolean numberSet = false;
	private boolean done = false;
	private List<String> lines;
	private int currectLineIndex;
	
	public FileNumberSource(Path file) throws IOException {
		lines = Files.readAllLines(file);
	}
	
	@Override
	public boolean hasMoreNumbers() {
		if(done) return false;
		if(numberSet) return true;
		while(currectLineIndex < lines.size()) {
			String line = lines.get(currectLineIndex).trim();
			currectLineIndex++;
			if(line.isEmpty()) continue;
			try {
				number = Double.parseDouble(line);
				numberSet = true;
				return true;
			} catch(NumberFormatException ex) {
				System.out.println("Unexpected input: " + line);
			}
		}
		done = true;
		return false;
	}
	
	@Override
	public double getNumber() {
		if(!hasMoreNumbers()) throw new IllegalStateException("No more numbers!");
		numberSet = false;
		return number;
	}
}