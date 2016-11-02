package hr.fer.oop.iostreams;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class DumpBinaryFile {

	public static void main(String[] args) {		
		Path p = Paths.get("D:/temp/photo.jpg");		
		try (InputStream is = Files.newInputStream(p, StandardOpenOption.READ)) {
			byte[] buff = new byte[1024];
			while (true) {
				int r = is.read(buff);
				if (r < 1)
					break;
				for(int i=0; i<r; i++)
					System.out.format("%02x ", buff[i]);
			}
		} 
		catch (IOException ex) {
			System.err.println(ex);
		}
	}
}
