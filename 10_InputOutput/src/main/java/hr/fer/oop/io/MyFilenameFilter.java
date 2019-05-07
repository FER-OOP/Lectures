package hr.fer.oop.io;

import java.io.File;
import java.io.FilenameFilter;

public class MyFilenameFilter implements FilenameFilter {

	@Override
	public boolean accept(File dir, String name) {
		return name.endsWith(".java") || name.endsWith(".class")
			   || new File(dir,name).isDirectory();
	}
}
