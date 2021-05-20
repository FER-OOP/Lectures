package hr.fer.oop.collections_and_customclasses;

public class Student {
	protected final String lastName;
	protected final String firstName;
	protected final String studentID;
	
	public Student(String lastName, String firstName, String studentID) {		
		this.lastName = lastName;
		this.firstName = firstName;
		this.studentID = studentID;
	}
	
	public final String getFirstName() {
		return firstName;
	}
	
	public final String getLastName() {
		return lastName;
	}
	
	public final String getStudentID() {
		return studentID;
	}
	
	@Override
	public String toString() {
		return String.format("(%s) %s %s", studentID, firstName, lastName);
	}
}