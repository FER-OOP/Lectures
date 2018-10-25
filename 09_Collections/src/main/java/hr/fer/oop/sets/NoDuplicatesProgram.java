package hr.fer.oop.sets;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class NoDuplicatesProgram {

	public static void main(String[] args) {
		System.out.println("Using HashSet:");
		writeCollection(addToSet(new HashSet<String>(), args));
		
		System.out.println("Using TreeSet:");
		writeCollection(addToSet(new TreeSet<String>(), args));
		
		System.out.println("Using LinkedHashSet:");
		writeCollection(addToSet(new LinkedHashSet<String>(), args));
	}

	private static Set<String> addToSet(Set<String> set, String[] elements) {
		for (String element : elements) {
			set.add(element);
		}
		return set;
	}

	private static void writeCollection(Iterable<String> col) {
		for (String element : col) {
			System.out.println(element);
		}
		System.out.println();
		
		//if using iterator instead of for-each
		
//		Iterator<String> iterator = col.iterator();
//		while(iterator.hasNext()) {
//			System.out.println(iterator.next());
//		}
	}
}
