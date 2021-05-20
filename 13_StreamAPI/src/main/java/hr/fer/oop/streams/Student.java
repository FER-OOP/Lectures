package hr.fer.oop.streams;

import java.text.Collator;
import java.util.Comparator;
import java.util.Locale;

public class Student implements Comparable<Student> {
	
	private String lastName;
	private String firstName;
	private String studentID;
	private int points;
	
	public Student(String lastName, String firstName, String studentID, int points) {
		super();
		this.lastName = lastName;
		this.firstName = firstName;
		this.studentID = studentID;
		this.points = points;
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

	public int getPoints() {
		return points;
	}
	
	@Override
	public String toString() {
		return String.format("(%s) %s %s points=%d", studentID, firstName, lastName, points);
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
	
	//private static Comparator<Object> comparator = Collator.getInstance(Locale.CHINA);
	private static Comparator<Object> comparator = Collator.getInstance(Locale.forLanguageTag("hr")); 
	
	public static final Comparator<Student> BY_LAST_NAME = (o1,o2) -> comparator.compare(o1.lastName, o2.lastName);
	public static final Comparator<Student> BY_FIRST_NAME = (o1,o2) -> comparator.compare(o1.firstName, o2.firstName);
	public static final Comparator<Student> BY_STUDENT_ID = (o1,o2) -> o1.studentID.compareTo(o2.studentID);
	//public static final Comparator<Student> BY_STUDENT_ID = Comparator.comparing(Student::getStudentID);
	public static final Comparator<Student> BY_POINTS = (o1,o2) -> Integer.compare(o1.points, o2.points);
}

