package hr.fer.oop.nio.dirtree;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) { 
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter directory:");
			String dirName = sc.nextLine();
			Path root = Path.of(dirName).toAbsolutePath();
			directoryTree(root, 0);
		}	
	}	
	
	public static void directoryTree(Path directory, int level) {
		print(level, directory.getFileName().toString(), false);		
				
		DirectoryStream.Filter<Path> filter = new MyPathStreamFilter();
		
		try(DirectoryStream<Path> dirStream = Files.newDirectoryStream(directory, filter)) {
			for(Path path : dirStream){
				if (Files.isDirectory(path)){ //or Files.readAttributes(path, BasicFileAttributes.class).isDirectory()
					directoryTree(path, level + 1);
				} else {
					print(level+1, 
						  String.format("%s (%s bytes) (%s) ",
								path.getFileName().toString(), 
								Files.size(path), 
								Files.getLastModifiedTime(path).toString()
						  ), 
						  true);
				}
			}
		}
	    catch (IOException e) {
			e.printStackTrace();
		}

	}

	private static void print(int level, String stringToPrint, boolean isFile) {
		if (level != 0)
			System.out.print("|");		
		for(int i=0; i<level-1; i++)
			System.out.print(isFile ? " " :  "-");
		System.out.println(stringToPrint);
	}
}
