package hr.fer.oop.collections.task1;

import java.util.Set;
import static hr.fer.oop.collections.task1.SetOperations.*;

public class Main {

	public static void main(String[] args) {
		var set1 = Set.of(1,2,3,4,5);
		var set2 = Set.of(3,4,5,6,7);
		
		System.out.println(union(set1, set2));
		System.out.println(intersection(set1, set2));
		
		System.out.println(difference(set1, set2));
		
		System.out.println(difference(set2, set1));
	}
}
