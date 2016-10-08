package hr.fer.oop.lists;

import java.util.LinkedHashSet;
import java.util.Set;

public class Example2c {

	public static void main(String[] args) {

		String[] names = { "Eva", "Ivan", "Eva", "Ante", "Ivan", "Jasna", "Stjepan", "Jasna" };

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
