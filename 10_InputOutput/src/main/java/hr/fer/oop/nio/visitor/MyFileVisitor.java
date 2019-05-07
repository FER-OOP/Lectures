package hr.fer.oop.nio.visitor;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class MyFileVisitor extends SimpleFileVisitor<Path> {

    int level = 0;

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {

        if (file.toString().endsWith(".java") || file.toString().endsWith(".class")) {
            print(level, String.format("%s (%s bytes) (%s) ",
                    file.getFileName().toString(),
                    attrs.size(),
                    attrs.lastModifiedTime().toString()), true);
        }

        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        print(level, dir.getFileName().toString(), false);        
        level++;

        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        level--;

        return FileVisitResult.CONTINUE;
    }

    private void print(int level, String stringToPrint, boolean isFile) {
        if (level != 0) {
            System.out.print("|");
        }
        for (int i = 0; i < level - 1; i++) {
            System.out.print(isFile ? " " : "-");
        }
        System.out.println(stringToPrint);
    }
}
