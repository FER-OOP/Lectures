package hr.fer.oop.collections_and_customclasses.example5;


import java.util.HashSet;
import java.util.Set;

public class HashSetMain {
	
	public static void main(String[] args) {
		Set<Student> students = new HashSet<>();
		Student s1 = new Student("Black", "Joe", "1234567890");
		Student s2 = new Student("Poe", "Edgar Allan", "2345678901");
		Student s3 = new Student("Kant", "Immanuel", "3456789012");
		students.add(s1);
		students.add(s2);
		students.add(s3);

		System.out.println("I have following students:");
		for(Student s : students) {
			System.out.println(s);
		}
		System.out.println();
		
		Student ss = new Student("Poe", "Edgar Allan", "2345678901");
		System.out.println("Poe present: " + students.contains(s2));
		System.out.println("Poe present: " + students.contains(ss));
	}
}
