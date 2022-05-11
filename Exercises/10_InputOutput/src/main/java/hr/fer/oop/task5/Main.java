package hr.fer.oop.task5;

import java.io.IOException;
import java.nio.file.*;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter directory:");
			String dirName = sc.nextLine();
			FileVisitor<Path> visitor = new MyFileVisitor();
			Path path = Paths.get(dirName);
			Files.walkFileTree(path, visitor);
		}
	}

}
