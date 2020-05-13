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
		Path outputFolder = Paths.get("./output");		
		
		try {			
			if (Files.notExists(outputFolder)) {
				Files.createDirectory(outputFolder);
			}
			
			AccountsVisitor visitor = new AccountsVisitor();
			Files.walkFileTree(racuni, visitor);			
			
			Map<Integer, YearInfo> map = visitor.getData();
			for(Integer year : map.keySet()) {
				Path outputFile = Paths.get(String.format("./output/%d.txt", year)); 
				if(Files.notExists(outputFile, LinkOption.NOFOLLOW_LINKS)){
					Files.createFile(outputFile);										
				}		
				writeInfo(map.get(year), outputFile);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}					
	}

	private static void writeInfo(YearInfo yearInfo, Path outputFile) throws UnsupportedEncodingException, FileNotFoundException, IOException  {
		try(Writer writer = new BufferedWriter(
				  new OutputStreamWriter(
				    new BufferedOutputStream(
				      new FileOutputStream(outputFile.toFile())),"UTF-8"))){
			
			String data = String.format("%d%n%.2f", yearInfo.count, yearInfo.totalAmount);
			writer.write(data);					
		}

		
	}

}
