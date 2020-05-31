package hr.fer.oop.collections_and_customclasses.example5;

import hr.fer.oop.collections_and_customclasses.example4.Student4;

public class Student5 extends Student4 implements Comparable<Student5> {	
	
	public Student5(String lastName, String firstName, String studentID) {
		super(lastName, firstName, studentID);	
	}	
		
    @Override
    public int compareTo(Student5 other) {
      return this.studentID.compareTo(other.studentID);
    }

}