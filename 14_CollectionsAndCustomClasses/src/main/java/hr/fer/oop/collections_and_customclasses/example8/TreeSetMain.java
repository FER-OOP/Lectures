package hr.fer.oop.collections_and_customclasses.example8;


import java.util.TreeSet;

import hr.fer.oop.collections_and_customclasses.Common;

import java.util.Set;

public class TreeSetMain {
	
	public static void main(String[] args) {		
		Set<Student> students = new TreeSet<>(new StudentComparator());
		//or using lambda
//		Set<Student> students = new TreeSet<>(
//				(s1, s2) -> s1.getStudentID().compareTo(s2.getStudentID())
//		);
		Common.fillStudentsCollection(students, Student::new);			
		System.out.println("I have following students:");
		Common.printCollection(students);
		
		Student s = new Student("Poe", "Edgar Allan", "2345678901");		
		System.out.println("Poe present: " + students.contains(s));
	}
}
