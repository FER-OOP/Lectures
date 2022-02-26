package hr.fer.oop.lab5.task1;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author OOP
 */
public class AccountsVisitor extends SimpleFileVisitor<Path>{
	
	private Map<Integer, YearInfo> map = new HashMap<>();
		
	@Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {			
		System.out.println("reading file :"+file.toString());
		
		
		int year = Integer.parseInt(file.getName(file.getNameCount()-3).toString());
		map.putIfAbsent(year, new YearInfo());
		YearInfo info = map.get(year);
		
		if(file.toString().endsWith("txt")){
			try(Scanner sc = new Scanner(file)) {
				while(sc.hasNextLine()) {
					String line = sc.nextLine();
					if (line.startsWith("UKUPNO")) {
						double total = Double.parseDouble(line.substring(6));
						++info.count;
						info.totalAmount += total;
						break;
					}	
				}
			}								
		}		
		return FileVisitResult.CONTINUE;
	}

	public Map<Integer, YearInfo> getData() {
		return map;
	}

}
