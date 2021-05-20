package hr.fer.oop.collections_and_customclasses.example2;

import hr.fer.oop.collections_and_customclasses.Student;

public class Student2 extends Student {		
	public Student2(String lastName, String firstName, String id) {
		super(lastName, firstName, id);		
	}
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Student2)) return false;
		Student2 other = (Student2)obj;
		return this.studentID.equals(other.studentID);
	}
}