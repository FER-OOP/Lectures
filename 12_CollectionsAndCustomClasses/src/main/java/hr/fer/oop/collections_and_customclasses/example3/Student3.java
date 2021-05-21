package hr.fer.oop.collections_and_customclasses.example3;

import hr.fer.oop.collections_and_customclasses.Student;

public class Student3 extends Student {		
	public Student3(String lastName, String firstName, String studentID) {
		super(lastName, firstName, studentID);		
	}
			
	@Override
	public int hashCode(){
		return this.studentID.hashCode();
	}
}