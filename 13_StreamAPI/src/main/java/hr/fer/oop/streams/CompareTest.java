package hr.fer.oop.streams;

import java.io.UnsupportedEncodingException;
import java.text.Collator;
import java.util.Comparator;
import java.util.Locale;

public class CompareTest {

	public static void main(String[] args) throws UnsupportedEncodingException {
		Comparator<Object> compHR = Collator.getInstance(Locale.forLanguageTag("hr"));
		Comparator<Object> compChina = Collator.getInstance(Locale.CHINA);
		
		String s1 = "王"; //Wáng
		String s2 = "周"; //Zhōu
		//Wáng should be before Zhōu
		
		System.out.println(s1.compareTo(s2));
		System.out.println(compChina.compare(s1, s2));	
		System.out.println(compHR.compare(s1, s2));	
		
		
		s1 = "č"; 
		s2 = "ć"; 
		//č should be before ć in Croatian
		
		System.out.println(s1.compareTo(s2));
		System.out.println(compChina.compare(s1, s2));	
		System.out.println(compHR.compare(s1, s2));
		
	}
}
