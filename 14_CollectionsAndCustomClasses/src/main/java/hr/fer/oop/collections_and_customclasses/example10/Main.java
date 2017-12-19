package hr.fer.oop.collections_and_customclasses.example10;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

import hr.fer.oop.collections_and_customclasses.Common;

public class Main {

	public static void main(String[] args) {		
		Comparator<Student> comparator = new CompositeComparator<>(
				Student.BY_FIRST_NAME.reversed(),
				Student.BY_LAST_NAME, 
				Comparator.naturalOrder() //same as Comparator.<Student>naturalOrder()
				);

		// or using default method in Comparator...
//		 Comparator<Student> comparator = Student.BY_FIRST_NAME
//		 .reversed()
//		 .thenComparing(Student.BY_LAST_NAME)
//		 .thenComparing(Comparator.naturalOrder());

		Set<Student> students = new TreeSet<>(comparator);

		Common.fillStudentsCollection(students, Student::new);
		System.out.println("I have following students:");
		Common.printCollection(students);
	}

}
