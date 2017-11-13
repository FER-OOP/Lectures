package hr.fer.oop.practice.z1_collections;

//TO DO: various imports

public class Statistics {
	//TO DO: variables, constructor
	
	public void addStudentWithGrade(String studentName, int grade) {
		//TO DO:
	}

	public void writeGrades() {
		//TO DO:
	}

	public void writeDetails() {
		//TO DO:
	}
	
	public static void main(String[] args) {
		Statistics statistics = new Statistics();
		statistics.addStudentWithGrade("Pero", 2);
		statistics.addStudentWithGrade("Pero", 3);
		statistics.addStudentWithGrade("Mara", 5);
		statistics.addStudentWithGrade("Ana", 2);
		
		System.out.println("**Statistics**");
		statistics.writeGrades();

		System.out.println("**Details**");
		statistics.writeDetails();
	}
}
