package hr.fer.oop.iostreams;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class CustomDecoratorExample {

	public static void main(String[] args) {
		String filename = "./test.bin";
		writeFile(filename);
		readFile(filename);
	}

	private static void writeFile(String filename) {
		try (OutputStream os = new ScrambledOutputStream(
									new FileOutputStream(filename), 
									(byte) 0xC3)) // 1100 0011 
		{
			os.write(150); //0x96 (1001 0110)
			os.write(new byte[] { 35, 70, 120 }); //0x23 (0010 0011) 0x46 (0100 0110) 0x78 (0111 1000)
			os.write(129); //0x81 (1000 0001)
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void readFile(String filename) {
		try (InputStream is = new FileInputStream(filename)) {
			int b;
			while ((b = is.read()) != -1){
				System.out.format("%s ", Integer.toBinaryString(b));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
