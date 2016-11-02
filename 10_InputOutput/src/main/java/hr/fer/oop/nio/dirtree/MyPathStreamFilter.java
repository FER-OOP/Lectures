package hr.fer.oop.nio.dirtree;

import java.io.IOException;
import java.nio.file.DirectoryStream.Filter;
import java.nio.file.Path;

public class MyPathStreamFilter implements Filter<Path> {

	@Override
	public boolean accept(Path entry) throws IOException {		
		return entry.toString().endsWith(".java") || entry.toString().endsWith(".class")
				|| entry.toFile().isDirectory(); 
	}

}
