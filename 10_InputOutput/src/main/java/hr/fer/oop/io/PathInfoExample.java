package hr.fer.oop.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class PathInfoExample {

	public static void main(String[] args) throws IOException {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter directory:");
			String dirName = sc.nextLine();			
			Path dir = Path.of(dirName);
			while (!Files.exists(dir) || !Files.isDirectory(dir)) {
				System.out.println("Directory does not exists. Enter directory:");
				dirName = sc.nextLine();
				dir = Path.of(dirName);
			}
			
			System.out.println("Choosen directory: " + dir.toAbsolutePath());

			while (true) {
				System.out.println("Enter file or directory name or quit to quit program:");
				String name = sc.nextLine();
				if ("quit".equalsIgnoreCase(name))
					break;
				Path file = dir.resolve(name);
				showPathInfo(file);
			}
		}
	}

	private static void showPathInfo(Path path) throws IOException {		
		String absolutePath = path.toAbsolutePath().toString();
		System.out.println("\t " + absolutePath);
		System.out.println("\t Path parts:");
		for(Path part : path) {
			System.out.printf(" %s", part.toString());
		}
		System.out.println();
		boolean exists = Files.exists(path);
		System.out.println("\t File exists?: " + exists);
		if (exists) {
			long fileSize = Files.size(path);
			System.out.println("\t File size: " + fileSize);
			boolean isHidden = Files.isHidden(path);
			System.out.println("\t Is hidden?: " + isHidden);
		}
		boolean readable = Files.isReadable(path);
		System.out.println("\t Can read?: " + readable);
		boolean writeable = Files.isWritable(path);
		System.out.println("\t Can write?: " + writeable);
		boolean executable = Files.isExecutable(path);
		System.out.println("\t Can execute?: " + executable);
		
		boolean isFile = Files.isRegularFile(path);
		System.out.println("\t Is file?: " + isFile);
		boolean isDirectory = Files.isDirectory(path);
		System.out.println("\t Is directory?: " + isDirectory);		
	}
}
