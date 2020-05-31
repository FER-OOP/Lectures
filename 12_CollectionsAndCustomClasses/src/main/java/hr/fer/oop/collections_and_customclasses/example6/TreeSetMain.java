package hr.fer.oop.collections_and_customclasses.example6;


import java.util.TreeSet;

import hr.fer.oop.collections_and_customclasses.Common;
import hr.fer.oop.collections_and_customclasses.example4.Student4;

import java.util.Set;

public class TreeSetMain {
	
	public static void main(String[] args) {		
		Set<Student4> students = new TreeSet<>(new StudentComparator());
		//or using lambda
//		Set<Student4> students = new TreeSet<>(
//				(s1, s2) -> s1.getStudentID().compareTo(s2.getStudentID())
//		);
		Common.fillStudentsCollection(students, Student4::new);			
		System.out.println("I have following students:");
		Common.printCollection(students);
		
		Student4 s = new Student4("Poe", "Edgar Allan", "2345678901");		
		System.out.println("Poe present: " + students.contains(s));
	}
}
