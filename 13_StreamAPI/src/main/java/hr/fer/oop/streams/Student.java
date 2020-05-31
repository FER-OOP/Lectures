package hr.fer.oop.streams;

import java.text.Collator;
import java.util.Comparator;
import java.util.Locale;

public class Student  implements Comparable<Student> {
	
	private String lastName;
	private String firstName;
	private String studentID;
	private int finalGrade;
	
	public Student(String lastName, String firstName, String studentID, int finalGrade) {
		super();
		this.lastName = lastName;
		this.firstName = firstName;
		this.studentID = studentID;
		this.finalGrade = finalGrade;
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

	public int getFinalGrade() {
		return finalGrade;
	}
	
	@Override
	public String toString() {
		return String.format("(%s) %s %s grade=%d", studentID, firstName, lastName, finalGrade);
	}
	
	@Override
	public int hashCode() {
		return this.studentID.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Student)) return false;
		Student other = (Student)obj;
		return this.studentID.equals(other.studentID);
	}
	
	@Override
	public int compareTo(Student o) {
		return this.studentID.compareTo(o.studentID);
	}
	
	private static Comparator<Object> hrcomparator = Collator.getInstance(Locale.forLanguageTag("hr"));
	public static final Comparator<Student> BY_LAST_NAME = (o1,o2) -> hrcomparator.compare(o1.lastName, o2.lastName);
	public static final Comparator<Student> BY_FIRST_NAME = (o1,o2) -> hrcomparator.compare(o1.firstName, o2.firstName);
	public static final Comparator<Student> BY_STUDENT_ID = (o1,o2) -> o1.studentID.compareTo(o2.studentID);
	public static final Comparator<Student> BY_FINAL_GRADE = (o1,o2) -> Integer.compare(o1.finalGrade, o2.finalGrade);
}

