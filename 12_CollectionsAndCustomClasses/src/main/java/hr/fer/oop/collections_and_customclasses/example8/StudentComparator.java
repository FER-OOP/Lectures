package hr.fer.oop.collections_and_customclasses.example8;

import java.util.Comparator;


public class StudentComparator implements Comparator<Student> {

	@Override
	public int compare(Student s1, Student s2) {
		return s1.getStudentID().compareTo(s2.getStudentID());	
	}

}
