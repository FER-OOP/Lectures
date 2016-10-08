package hr.fer.oop.maps;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Example5 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		Map<String, Integer> names = new HashMap<>(); // 5a
		// Map<String, Integer> names = new TreeMap<>(); //5b
		// Map<String, Integer> names = new LinkedHashMap<>(); //5c
		
		System.out.println("Enter names (quit for end):");
		String name;
		while (!(name = scanner.next()).equals("quit")) {
			Integer val = names.get(name);			
			names.put(name, val == null ? 1 : val + 1);
		}

		for (Map.Entry<String, Integer> entry : names.entrySet())
			System.out.format("%s occured %d time(s)%n", entry.getKey(), entry.getValue());

		scanner.close();
	}

}
