package hr.fer.oop.pred.kolekcije.av.zad4;

import java.util.*;

public class Grades2 {
	
	Map<String, List<Integer>> gradesMap;
	
	public Grades2() {
		gradesMap = new HashMap<>();
	}
	
	public void add(String name, Integer grade) {
		List<Integer> values = gradesMap.get(name);
		if (values == null) {
			values = new LinkedList<Integer>();
			gradesMap.put(name, values);
		}
		values.add(grade);
	}
	
	public void avgGrades() {
		double avg = 0;
		for (String name : gradesMap.keySet()) {
			double avgStud = 0;
			List<Integer> listaOcjena = gradesMap.get(name);
			for (Integer grade : listaOcjena)
				avgStud += grade;
			avgStud /= listaOcjena.size();
			System.out.println(name + " : " + listaOcjena + " " + avgStud);
			avg += avgStud;
		}
		System.out.println("Average grade: " + avg/gradesMap.size());
	}

	public static void main(String[] args) {
		Grades2 g = new Grades2();
		
		g.add("Marko", 5);
		g.add("Iva", 3);
		g.add("Ivana", 5);
		g.add("Matteo", 2);
		g.add("Mario", 1);
		
		g.add("Mario", 4);
		g.add("Mario", 4);
		
		g.avgGrades();
	}

}
