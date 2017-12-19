package hr.fer.oop.collections_and_customclasses.example9;


import java.util.TreeSet;

import hr.fer.oop.collections_and_customclasses.Common;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Set;

public class Main {
	
	public static void main(String[] args) {
		StudentComparator comparator = new StudentComparator();		
		//Comparator<Student> reverse = new ReverseComparator<>(comparator);
				
		//Comparator<Student> reverse = comparator.reversed(); //using Java8 default method in Comparator interface:
		
		Comparator<Student> reverse = Collections.reverseOrder(comparator); //using static method from Collections class
		
		Set<Student> students = new TreeSet<>(reverse);
		
		Common.fillStudentsCollection(students, Student::new);			
		System.out.println("I have following students:");
		Common.printCollection(students);		
	}
	
	
}
