package hr.fer.oop.practice.z1_collections;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Statistics {
	private List<Set<String>> grades; //or Map<Integer, Set<String>> ...
	private Set<String> allStudents;	
		
	public Statistics() {
		allStudents = new HashSet<>();
		grades = new ArrayList<>(5);
		for(int i=0; i<5 ; i++){
			grades.add(new TreeSet<>());
		}
	}
	
	public void addStudentWithGrade(String studentName, int grade) {		
		if(allStudents.add(studentName)) {
			grades.get(grade-1).add(studentName);			
		}
	}

	public void writeGrades() {
		for(int i=0; i<5; i++) {
			System.out.format("grade %d: %.2f%n", i+1, 100.0 * grades.get(i).size() / allStudents.size() );
		}
	}

	public void writeDetails() {
		for(int i=0; i<5; i++) {
			System.out.format("grade %d:%n", i+1);
			for(String name : grades.get(i)) {
				System.out.println("  " + name);
			}
		}
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
