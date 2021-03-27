package hr.fer.oop.homework_05.e06;

public class Teacher extends Person {

	private String subject;
	private double teacherGrade;
	
	public Teacher(int id, String name, String subject, double teacherGrade) {
		super(id, name);
		this.subject = subject;
		this.teacherGrade = teacherGrade;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public double getTeacherGrade() {
		return teacherGrade;
	}

	public void setTeacherGrade(double teacherGrade) {
		this.teacherGrade = teacherGrade;
	}

	@Override
	public String toString() {
		return super.toString() + ", subject=" + subject + ", teacherGrade=" + teacherGrade;
	}

	@Override
	public double getGrade() {
		return teacherGrade;
	}
	
}