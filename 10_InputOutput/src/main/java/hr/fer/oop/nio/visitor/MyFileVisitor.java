package hr.fer.oop.nio.visitor;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class MyFileVisitor extends SimpleFileVisitor<Path> {
	int firstLevel = 0;

	@Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {

		if (file.toString().endsWith(".java") || file.toString().endsWith(".class")) {
			int level = file.getNameCount();
			print(level - firstLevel, String.format("%s (%s bytes) (%s) ", 
										file.getName(level - 1).toString(),
										attrs.size(), 
										attrs.lastModifiedTime().toString())
				 , true);
		}

		return FileVisitResult.CONTINUE;
	}

	@Override
	public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {

		if (firstLevel == 0) {
			firstLevel = dir.getNameCount();
			System.out.println(dir);
		} else {
			int level = dir.getNameCount();
			print(level - firstLevel, dir.getName(level - 1).toString(), false);
		}

		return FileVisitResult.CONTINUE;
	}

	private void print(int level, String name, boolean isFile) {
		if (level != 0)
			System.out.print("|");
		for (int i = 0; i < level - 1; i++)
			System.out.print(isFile ? " " : "-");
		System.out.println(name);
	}
}
