package hr.fer.oop.collections.task3;

import java.util.*;

public class Grades3 {

	private Map<String, Map<String, Integer>> studentGrades;
	
	public Grades3() {
		studentGrades = new HashMap<>();
	}
	
	public void add(String student, String course, Integer grade) {
		Map<String, Integer> courseGradeMap = studentGrades.get(student);
		if (courseGradeMap == null) {
			courseGradeMap = new HashMap<String, Integer>();
			studentGrades.put(student, courseGradeMap);
		}
		courseGradeMap.put(course, grade);
	}
	
	public void courseAvg(String course) {
		double sum = 0;
		int count = 0;
		
		for (String student : studentGrades.keySet()) {
			Map<String, Integer> courseGradeMap = studentGrades.get(student);
			if (courseGradeMap.containsKey(course)) {
				Integer courseGrade = courseGradeMap.get(course);
				System.out.println(student + " : " + course + " : " + courseGrade);
				sum += courseGrade;
				count++;
			}
		}
		
		System.out.println("Average course grade: " + sum / count);
		
	}
	
	public static void main(String[] args) {
		
		Grades3 g = new Grades3();
		
		g.add("Marko", "OOP", 5);
		g.add("Iva", "OOP", 3);
		g.add("Ivana", "OOP", 5);
		g.add("Matteo", "OOP", 2);
		g.add("Mario", "OOP", 1);
		
		g.add("Mario", "MAT", 4);
		g.add("Matteo", "MAT", 5);
		
		g.courseAvg("MAT");

	}

}
