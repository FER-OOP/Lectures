package hr.fer.oop.pred.kolekcije.av.zad4;

import java.util.*;

public class Grades3 {

	Map<String, Map<String, Integer>> gradesMap;
	
	public Grades3() {
		gradesMap = new HashMap<>();
	}
	
	public void add(String name, String course, Integer grade) {
		Map<String, Integer> courseGradeMap = gradesMap.get(name);
		if (courseGradeMap == null) {
			courseGradeMap = new HashMap<String, Integer>();
			gradesMap.put(name, courseGradeMap);
		}
		courseGradeMap.put(course, grade);
	}
	
	public void courseAvg(String course) {
		double sum = 0;
		int count = 0;
		
		for (String name : gradesMap.keySet()) {
			Map<String, Integer> courseGradeMap = gradesMap.get(name);
			if (courseGradeMap.containsKey(course)) {
				Integer courseGrade = courseGradeMap.get(course);
				System.out.println(name + " : " + course + " : " + courseGrade);
				sum += courseGrade;
				count++;
			}
		}
		
		System.out.println("Average course grade: " + sum/count);
		
	}
	
	public static void main(String[] args) {
		
		Grades3 g = new Grades3();
		
		g.add("Marko", "OOP", 5);
		g.add("Iva", "OOP", 3);
		g.add("Ivana", "OOP", 5);
		g.add("Matteo", "OOP", 2);
		g.add("Mario", "OOP", 1);
		
		g.add("Mario", "ARH", 4);
		g.add("Matteo", "ARH", 5);
		
		g.courseAvg("ARH");

	}

}
