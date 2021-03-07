package hr.fer.oop.homework_01_02;

import java.util.Random;
import java.util.Scanner;

public class RandomWords {

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		Scanner sc = new Scanner(System.in);
		Random r = new Random();
		String line;		
		while(!(line = sc.nextLine()).equalsIgnoreCase("quit")) {
			line = line.trim();
			if (line.length() != 0) {
				int pos = r.nextInt(line.length());
				while(line.charAt(pos) == ' ')
					--pos;
				int begin = line.lastIndexOf(' ', pos);				
				int end = line.indexOf(' ', pos);
				if (end == -1) 
					end = line.length();
				
				String word = line.substring(begin + 1, end);				
				sb.append(word.toUpperCase());
				sb.append(' ');				
			}
		}
		System.out.println(sb.toString());
	}

}
