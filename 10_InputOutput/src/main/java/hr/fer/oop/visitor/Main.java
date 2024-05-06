package hr.fer.oop.visitor;

import java.io.IOException;
import java.nio.file.*;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter directory:");
		String dirName = sc.nextLine();
		FileVisitor<Path> visitor = new MyFileVisitor();
		Path path = Path.of(dirName);
		try {
			Files.walkFileTree(path, visitor);
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
}
