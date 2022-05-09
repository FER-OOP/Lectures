package hr.fer.oop.io;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class DirContent {

	public static void main(String[] args) throws IOException { 
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter directory:");
		String dirName = sc.nextLine();
		Path directory = Path.of(dirName);
		
		DirectoryStream.Filter<Path> filter = new FilterByExtensions("txt", "pdf", "pptx");
		
		try(DirectoryStream<Path> dirStream = Files.newDirectoryStream(directory, filter)) {
			for(Path path : dirStream){
				System.out.printf("%s (%s bytes) (%s) %n",
						path.getFileName().toString(), 
						Files.size(path), 
						Files.getLastModifiedTime(path).toString()
				  );			
			}
		}		
	}
}
