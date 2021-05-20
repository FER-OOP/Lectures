package hr.fer.oop.collections_and_customclasses.example7;

import java.util.Comparator;

import hr.fer.oop.collections_and_customclasses.example4.Student4;

public class StudentComparator implements Comparator<Student4> {
	@Override
	public int compare(Student4 s1, Student4 s2) {
		int r = s1.getLastName().compareTo(s2.getLastName());
		if (r != 0)
			return r;
		r = s1.getFirstName().compareTo(s2.getFirstName());
		if (r != 0)
			return r;
		return s1.getStudentID().compareTo(s2.getStudentID());

	}
}
