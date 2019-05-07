package hr.fer.oop.iostreams;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class EncodingExample {

	public static void main(String[] args) {
		Charset c = StandardCharsets.UTF_8;
		Charset c2 = Charset.forName("ISO-8859-2");
		byte[] bytes = new byte[] {-59, -95, -60, -111, -60, -115, -60, -121, -59, -66};
		String text = new String(bytes, c);
		byte[] bytes2 = text.getBytes(c2);
		
		for(byte b: bytes2)
			System.out.println(b/* & 0xFF*/);
		System.out.println(text);
	}

}
