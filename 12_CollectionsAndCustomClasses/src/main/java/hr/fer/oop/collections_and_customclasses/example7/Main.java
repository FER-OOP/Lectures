package hr.fer.oop.collections_and_customclasses.example7;


import java.util.TreeSet;

import hr.fer.oop.collections_and_customclasses.Common;
import hr.fer.oop.collections_and_customclasses.example4.Student4;

import java.util.Collections;
import java.util.Comparator;
import java.util.Set;

public class Main {
	
	public static void main(String[] args) {
		StudentComparator comparator = new StudentComparator();		
		//Comparator<Student4> reverse = new ReverseComparator<>(comparator);
				
		//Comparator<Student4> reverse = comparator.reversed(); //using Java8 default method in Comparator interface:
		
		Comparator<Student4> reverse = Collections.reverseOrder(comparator); //using static method from Collections class
		
		Set<Student4> students = new TreeSet<>(reverse);
		
		Common.fillStudentsCollection(students, Student4::new);			
		System.out.println("I have following students:");
		Common.printCollection(students);		
	}
	
	
}
