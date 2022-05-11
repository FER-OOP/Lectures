package hr.fer.oop.task4;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class MyFileVisitor extends SimpleFileVisitor<Path> {
		
	private LinkedList<Path> files = new LinkedList<>();
	public List<Path> getLargestFiles() {
		return Collections.unmodifiableList(files);
	}

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {   	
    	int i=0;
		for(Path path : files) {
			if (attrs.size() > Files.size(path))
				break;
			++i;
		}
        files.add(i, file);
        if (files.size() > 10) {
        	files.removeLast();
        }
        	
        return FileVisitResult.CONTINUE;
    }

}
