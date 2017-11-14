package hr.fer.oop.lists;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// Using list and set...
// Appropriate set can offer fast lookup!

public class Example2b {

	public static void main(String[] args) {

		String[] names = { "Eva", "Ivan", "Eva", "Ante", "Ivan", "Jasna", "Stjepan", "Jasna" };

		writeInReverse(names);
	}

	private static void writeInReverse(String[] names) {		
		List<String> list = new ArrayList<>();
		// Set for fast lookup...
		Set<String> set = new HashSet<>();
		for (int i = names.length - 1; i >= 0; i--) {
			// Try add. If OK, first occurrence => add to list.
			if (set.add(names[i])) {
				list.add(names[i]);
			}
		}		
		for (String name : list) {
			System.out.println(name);
		}
	}
}
