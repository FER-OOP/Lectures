package hr.fer.oop.collections_and_customclasses.example10;

import java.util.Comparator;

public class Student implements  Comparable<Student> {
	private String lastName;
	private String firstName;
	private String studentID;
	
	public Student(String lastName, String firstName, String studentID) {
		super();
		this.lastName = lastName;
		this.firstName = firstName;
		this.studentID = studentID;
	}
	

	public String getFirstName() {
		return firstName;
	}
	

	public String getLastName() {
		return lastName;
	}
	
	
	public String getStudentID() {
		return studentID;
	}
	
	@Override
	public String toString() {
		return String.format("(%s) %s %s", studentID, firstName, lastName);
	}
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Student)) return false;
		Student other = (Student)obj;
		return this.studentID.equals(other.studentID);
	}
	
	@Override
	public int hashCode(){
		return this.studentID.hashCode();
	}

	@Override
	public int compareTo(Student o) {
		return this.studentID.compareTo(o.studentID);
	}	
	
	public static final Comparator<Student> BY_LAST_NAME = (s1,s2) -> s1.lastName.compareTo(s2.lastName);
	//public static final Comparator<Student> BY_FIRST_NAME = (s1,s2) -> s1.firstName.compareTo(s2.firstName);
        public static final Comparator<Student> BY_FIRST_NAME = Comparator.comparing(Student::getFirstName);
	public static final Comparator<Student> BY_STUDENT_ID = (s1,s2) -> s1.studentID.compareTo(s2.studentID);

	    
}