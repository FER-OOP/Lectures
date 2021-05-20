package hr.fer.oop.collections_and_customclasses.example6;

import java.util.Comparator;

import hr.fer.oop.collections_and_customclasses.example4.Student4;


public class StudentComparator implements Comparator<Student4> {

	@Override
	public int compare(Student4 s1, Student4 s2) {
		return s1.getStudentID().compareTo(s2.getStudentID());	
	}

}
