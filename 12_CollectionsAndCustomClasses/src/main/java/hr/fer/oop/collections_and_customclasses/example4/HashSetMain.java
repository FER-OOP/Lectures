package hr.fer.oop.collections_and_customclasses.example4;


import java.util.HashSet;
import java.util.Set;

import hr.fer.oop.collections_and_customclasses.Common;

public class HashSetMain {
	
	public static void main(String[] args) {
		Set<Student> students = new HashSet<>();
		Common.fillStudentsCollection(students, Student::new);			
		System.out.println("I have following students:");
		Common.printCollection(students);
		
		Student s = new Student("Poe", "Edgar Allan", "2345678901");		
		System.out.println("Poe present: " + students.contains(s));
	}
}
