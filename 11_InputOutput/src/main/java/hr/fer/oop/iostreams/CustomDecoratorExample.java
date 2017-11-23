package hr.fer.oop.iostreams;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class CustomDecoratorExample {

	public static void main(String[] args) {
		String filename = "D:/temp/test.bin";
		writeFile(filename);
		readFile(filename);
	}

	private static void writeFile(String filename) {
		try (OutputStream os = new ScrambledOutputStream(
									new FileOutputStream(filename), 
									(byte) 0xF0,
									(byte) 0x0F)) 
		{
			os.write(150); //0x96
			os.write(new byte[] { 35, 70, 120 }); //0x23 0x46 0x78
			os.write(129); //0x81
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void readFile(String filename) {
		try (InputStream is = new FileInputStream(filename)) {
			int b;
			while ((b = is.read()) != -1){
				System.out.format("%02x ", b);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
