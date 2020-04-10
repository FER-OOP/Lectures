package hr.fer.oop.collections;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class MapExample {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		Map<String, Integer> names = new HashMap<>(); 
		// Map<String, Integer> names = new TreeMap<>(); 
		// Map<String, Integer> names = new LinkedHashMap<>(); 
		
		System.out.println("Enter names (quit for end):");
		String name;
		while (!(name = scanner.next()).equals("quit")) {
			Integer val = names.get(name);			
			names.put(name, val == null ? 1 : val + 1);
		}

		for (Map.Entry<String, Integer> entry : names.entrySet()) {
			//entry.setValue(entry.getValue() + 1); //allowed
			//names.put("John", 7); //allowed only if John exists as key (thus it is only value change)
			System.out.format("%s occured %d time(s)%n", entry.getKey(), entry.getValue());	
		}
	}

}
