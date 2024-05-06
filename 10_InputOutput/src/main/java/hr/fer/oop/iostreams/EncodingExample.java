package hr.fer.oop.iostreams;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class EncodingExample {

	public static void main(String[] args) {
		System.out.println("Default charset is: " + Charset.defaultCharset());
		
		byte[] bytes = new byte[] {-59, -95, -60, -111, -60, -115, -60, -121, -59, -66};
		String text = new String(bytes, StandardCharsets.UTF_8);
		System.out.println(text);
		
		Charset charset = Charset.forName("ISO-8859-2"); //try e.g. cp1252, or StandardCharsets.UTF_16;
		
		byte[] bytes2 = text.getBytes(charset); 
		
		for(byte b: bytes2)
			System.out.println(b/* & 0xFF*/);
		
		String text2 = new String(bytes2, charset);
		System.out.println(text2);
		
		System.out.println(text.equals(text2));			
	}

}
