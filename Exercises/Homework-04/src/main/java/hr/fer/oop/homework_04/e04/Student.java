package hr.fer.oop.homework_04.e04;

import hr.fer.oop.homework_04.e03.Person;

public class Student extends Person {

	private String studentId;
	private short academicYear;
	
	public Student(String name, String surname, int age, String studentId, short academicYear) {
		super(name, surname, age);
		this.studentId = studentId;
		this.academicYear = academicYear;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public short getAcademicYear() {
		return academicYear;
	}

	public void setAcademicYear(short academicYear) {
		this.academicYear = academicYear;
	}
	
	@Override
	public String toString() {
		return super.toString() + ", studentId=" + studentId + ", academicYear=" + academicYear;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((studentId == null) ? 0 : studentId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) { //paziti na generirani equals code, provjerava i sadržaj atributa nadklase!
		if (this == obj)
			return true;

		Student other = (Student) obj;
		if (!studentId.equals(other.studentId))
			return false;
		
		return true;
	}
	
	
	
}
