package hr.fer.oop.collections.task3;

import java.util.*;

public class Grades1 {

	private Map<String, Integer> studentsGrades;
	
	public Grades1() {
		studentsGrades = new HashMap<>();
	}
	
	public void add(String student, Integer grade) {
		studentsGrades.put(student, grade);
	}
	
	public void avgGrades() {
		double sum = 0;
		for (Map.Entry<String, Integer> entry : studentsGrades.entrySet()) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
			sum += entry.getValue();
		}
		System.out.println("Average grade: " + sum / studentsGrades.size());
	}
	
	public static void main(String[] args) {
		Grades1 g = new Grades1();
		
		g.add("Marko", 5);
		g.add("Iva", 3);
		g.add("Ivana", 5);
		g.add("Matteo", 2);
		g.add("Mario", 1);
		
		g.avgGrades();

	}

}
