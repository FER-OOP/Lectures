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

			while (true) {
				System.out.println("Enter file or directory name or quit to quit program:");
				String name = sc.nextLine();
				if ("quit".equalsIgnoreCase(name))
					break;
				Path file = dir.resolve(name);
				showFileInfo(file);
			}
		}
	}

	private static void showFileInfo(Path file) throws IOException {		
		String absolutePath = file.toAbsolutePath().toString();
		System.out.println("\t " + absolutePath);
		Path parent = file.getParent();
		System.out.println("\t Parent file: " + parent);
		boolean exists = Files.exists(file);
		System.out.println("\t File exists?: " + exists);
		boolean readable = Files.isReadable(file);
		System.out.println("\t Can read?: " + readable);
		boolean writeable = Files.isWritable(file);
		System.out.println("\t Can write?: " + writeable);
		boolean executable = Files.isExecutable(file);
		System.out.println("\t Can execute?: " + executable);
		long fileSize = Files.size(file);
		System.out.println("\t File size: " + fileSize);
		boolean isFile = Files.isRegularFile(file);
		System.out.println("\t Is file?: " + isFile);
		boolean isDirectory = Files.isDirectory(file);
		System.out.println("\t Is directory?: " + isDirectory);
		boolean isHidden = Files.isHidden(file);
		System.out.println("\t Is hidden?: " + isHidden);

	}
}
