package hr.fer.oop.lab5.task2;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;


public class Statistics {

	public static void main(String[] args) {
		Map<String, List<Integer>> students = new TreeMap<>();
		String name;		
		Scanner sc = new Scanner(System.in);
		while(!(name = sc.next()).equals("KRAJ")) {
			int grade = sc.nextInt();
			List<Integer> grades = students.get(name);
			if (grades == null) {
				grades = new LinkedList<>();
				students.put(name, grades);
			}			
			grades.add(grade);
		}			
		printStats(students);
	}

	

	private static void printStats(Map<String, List<Integer>> students) { 		
		for(var entry : students.entrySet()) {
			System.out.println(entry.getKey());
			List<Integer> grades = entry.getValue();
			System.out.printf("\tBroj ocjena: %d%n", grades.size());
			System.out.print("\tOcjene:");
			int sum = 0;
			for(Integer grade : grades) {
				System.out.printf(" %d", grade);
				sum += grade;
			}
			double average =  (double) sum / grades.size();
			System.out.println();
			System.out.printf("\tProsjeÄ?na ocjena: %.2f%n", average);
						
			double deviation = 0;
			for(Integer grade : grades) { 
				deviation += (average - grade) * (average - grade); 
			}
			deviation = Math.sqrt(deviation / grades.size());
			System.out.printf("\tStandardno odstupanje: %.2f%n", deviation);
			System.out.println();

		}	
	}

}

