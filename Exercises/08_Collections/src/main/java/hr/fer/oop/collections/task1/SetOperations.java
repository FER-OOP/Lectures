package hr.fer.oop.collections.task1;

import java.util.*;

public class SetOperations {
	
	public static <T> Set<T> union(Set<T> set1, Set<T> set2) {
		Set<T> set = new HashSet<T>(set1);
		set.addAll(set2);
		return set;
	}
	
	public static <T> Set<T> intersection(Set<T> set1, Set<T> set2) {
		var set = new HashSet<T>(set1);
		set.retainAll(set2);
		return set;
	}

	public static <T> Set<T> difference(Set<T> set1, Set<T> set2) {
		var set = new HashSet<T>(set1);
		set.removeAll(set2);
		return set;
	}
}
