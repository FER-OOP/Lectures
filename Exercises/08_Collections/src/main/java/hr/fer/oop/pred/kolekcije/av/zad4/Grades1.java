package hr.fer.oop.pred.kolekcije.av.zad4;

import java.util.*;

public class Grades1 {

	Map<String, Integer> gradesMap;
	
	public Grades1() {
		gradesMap = new HashMap<>();
	}
	
	public void add(String name, Integer grade) {
		gradesMap.put(name, grade);
	}
	
	public void avgGrades() {
		double sum = 0;
		for (Map.Entry<String, Integer> entry : gradesMap.entrySet()) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
			sum += entry.getValue();
		}
		System.out.println("Average grade: " + sum/gradesMap.size());
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
