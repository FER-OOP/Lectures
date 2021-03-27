package hr.fer.oop.homework_05.e06;

import java.util.Arrays;

public class Student extends Person {
	
	private short academicYear;
	private int[] grades;
	
	public Student(int id, String name, short academicYear, int[] grades) {
		super(id, name);
		this.academicYear = academicYear;
		this.grades = grades;
	}

	public short getAcademicYear() {
		return academicYear;
	}

	public void setAcademicYear(short academicYear) {
		this.academicYear = academicYear;
	}

	public int[] getGrades() {
		return grades;
	}

	public void setGrades(int[] grades) {
		this.grades = grades;
	}

	@Override
	public String toString() {
		return super.toString() + ", academicYear=" + academicYear + ", grades=" + Arrays.toString(grades);
	}

	@Override
	public double getGrade() {
		if (grades.length < 1) return 0;
		double sum = 0;
		for (int i : grades)
			sum += i;
		return sum/grades.length;
	}
	
}