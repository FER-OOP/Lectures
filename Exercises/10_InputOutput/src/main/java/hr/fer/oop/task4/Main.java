package hr.fer.oop.task4;

import java.io.IOException;
import java.nio.file.*;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter directory:");
			String dirName = sc.nextLine();
			MyFileVisitor visitor = new MyFileVisitor();
			Path path = Paths.get(dirName);
			try {
				Files.walkFileTree(path, visitor);
				System.out.println("10 largest files:");
				for(Path file : visitor.getLargestFiles()) {
					System.out.printf("%s %d%n", file.getFileName().toString(), Files.size(file));
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
