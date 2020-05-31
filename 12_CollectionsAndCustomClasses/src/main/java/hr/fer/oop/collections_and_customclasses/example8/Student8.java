package hr.fer.oop.collections_and_customclasses.example8;

import java.util.Comparator;

import hr.fer.oop.collections_and_customclasses.example5.Student5;

public class Student8 extends Student5 {	
	
	public Student8(String lastName, String firstName, String studentID) {
		super(lastName, firstName, studentID);	
	}		
	
	public static final Comparator<Student8> BY_LAST_NAME = (s1,s2) -> s1.lastName.compareTo(s2.lastName);
	//public static final Comparator<Student> BY_FIRST_NAME = (s1,s2) -> s1.firstName.compareTo(s2.firstName);
    public static final Comparator<Student8> BY_FIRST_NAME = Comparator.comparing(Student8::getFirstName);
	public static final Comparator<Student8> BY_STUDENT_ID = (s1,s2) -> s1.studentID.compareTo(s2.studentID);

	    
}