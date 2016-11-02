package hr.fer.oop.io;

import java.io.File;
import java.util.Scanner;

public class FileInfoExample {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter directory:");
			String dirName = sc.nextLine();
			File dir = new File(dirName);
			while (!dir.exists() || !dir.isDirectory()) {
				System.out.println("Directory does not exists. Enter directory:");
				dirName = sc.nextLine();
				dir = new File(dirName);
			}

			while (true) {
				System.out.println("Enter file or directory name or quit to quit program:");
				String name = sc.nextLine();
				if ("quit".equalsIgnoreCase(name))
					break;
				File file = new File(dir, name); // or new File(dirName, name)
				showFileInfo(file);
			}
		}
	}

	private static void showFileInfo(File file) {
		String absolutePath = file.getAbsolutePath();
		System.out.println("\t " + absolutePath);
		File parent = file.getParentFile();
		System.out.println("\t Parent file: " + parent);
		boolean exists = file.exists();
		System.out.println("\t File exists?: " + exists);
		boolean readable = file.canRead();
		System.out.println("\t Can read?: " + readable);
		boolean writeable = file.canWrite();
		System.out.println("\t Can write?: " + writeable);
		boolean executable = file.canExecute();
		System.out.println("\t Can execute?: " + executable);
		long fileSize = file.length();
		System.out.println("\t File size: " + fileSize);
		boolean isFile = file.isFile();
		System.out.println("\t Is file?: " + isFile);
		boolean isDirectory = file.isDirectory();
		System.out.println("\t Is directory?: " + isDirectory);
		boolean isHidden = file.isHidden();
		System.out.println("\t Is hidden?: " + isHidden);

	}
}
