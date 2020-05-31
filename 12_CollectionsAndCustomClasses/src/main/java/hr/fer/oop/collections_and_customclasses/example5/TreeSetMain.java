package hr.fer.oop.collections_and_customclasses.example5;


import java.util.TreeSet;

import hr.fer.oop.collections_and_customclasses.Common;

import java.util.Set;

public class TreeSetMain {
	
	public static void main(String[] args) {
		Set<Student5> students = new TreeSet<>();
		Common.fillStudentsCollection(students, Student5::new);			
		System.out.println("I have following students:");
		Common.printCollection(students);
		
		Student5 s = new Student5("Poe", "Edgar Allan", "2345678901");
		System.out.println("Poe present: " + students.contains(s));	
	}
}
