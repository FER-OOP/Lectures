package hr.fer.oop.collections_and_customclasses.example1;

import java.util.ArrayList;
import java.util.List;

import hr.fer.oop.collections_and_customclasses.Common;
import hr.fer.oop.collections_and_customclasses.Student;
import hr.fer.oop.collections_and_customclasses.StudentFactory;

public class ArrayListMain {
	
	public static void main(String[] args) {
		List<Student> students = new ArrayList<>();
		StudentFactory<Student> factory = (last, first, id) -> new Student(last, first, id);
		// StudentFactory<Student> factory = Student::new;
		Common.fillStudentsCollection(students, factory);			
		System.out.println("I have following students:");
		Common.printCollection(students);
		
		Student s = new Student("Poe", "Edgar Allan", "2345678901");		
		System.out.println("Poe present: " + students.contains(s));				
	}	
}
