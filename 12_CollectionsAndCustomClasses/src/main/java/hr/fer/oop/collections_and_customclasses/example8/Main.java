package hr.fer.oop.collections_and_customclasses.example8;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

import hr.fer.oop.collections_and_customclasses.Common;

public class Main {

	public static void main(String[] args) {		
		Comparator<Student8> comparator = new CompositeComparator<>(
				Student8.BY_FIRST_NAME.reversed(),
				Student8.BY_LAST_NAME, 
				Comparator.naturalOrder() //same as Comparator.<Student>naturalOrder()
				);

		// or using default method in Comparator...
//		 Comparator<Student8> comparator = Student8.BY_FIRST_NAME
//		 .reversed()
//		 .thenComparing(Student8.BY_LAST_NAME)
//		 .thenComparing(Comparator.naturalOrder());

		Set<Student8> students = new TreeSet<>(comparator);

		Common.fillStudentsCollection(students, Student8::new);
		System.out.println("I have following students:");
		Common.printCollection(students);
	}

}
