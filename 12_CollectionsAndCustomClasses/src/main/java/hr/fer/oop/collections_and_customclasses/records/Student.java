package hr.fer.oop.collections_and_customclasses.records;

import java.util.Collection;

record Student(String lastName, String firstName, String studentID) {
	
	public static void fillStudentsCollection(Collection<Student> students) {		
		Student s1 = new Student("Black", "Joe", "1234567890");
		Student s2 = new Student("Poe", "Edgar Allan", "2345678901");
		Student s3 = new Student("Kant", "Immanuel", "3456789012");
		Student s4 = new Student("Rock", "Joe", "0123456789");
		Student s5 = new Student("Black", "Joe", "5687461359");
		
		students.add(s1);
		students.add(s2);
		students.add(s3);
		students.add(s4);	
		students.add(s5);	
	}
}