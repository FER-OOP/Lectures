package hr.fer.oop._old.iterable;

import java.util.Iterator;

public class Main {
	public static void main(String[] args) {
		FixedSizeCollection<String> col = new FixedSizeCollection<>(
				"Ana", "Ivana", "Jasmina");
		for(String s1 : col) {
			for(String s2 : col) {
				System.out.println(s1+", "+s2);
			}
		}

		FixedSizeCollection<String> col1 = 
				new FixedSizeCollection<>("Pero", "Ivo");

		FixedSizeCollection<String> col2 = 
				new FixedSizeCollection<>("Ana", "Jasna");

		Iterator<String> it1 = col1.iterator();
		System.out.println(it1.next()); // Pero
		
		Iterator<String> it2 = col2.iterator();
		System.out.println(it2.next()); // Ana

	}
}
