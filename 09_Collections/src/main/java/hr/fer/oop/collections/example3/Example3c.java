package hr.fer.oop.collections.example3;

import java.util.LinkedHashSet;
import java.util.Set;

public class Example3c {

	public static void main(String[] args) {
		
		String[] names = { "Boris", "Anna", "Boris", "Wang", "Anna", "Li", "Chen", "Li" };

		writeInReverse(names);
	}

	private static void writeInReverse(String[] names) {
		Set<String> set = new LinkedHashSet<>();
		for (int i = names.length - 1; i >= 0; i--) {
			set.add(names[i]);
		}
		for (String name : set) {
			System.out.println(name);
		}
	}
}
