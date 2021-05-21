package hr.fer.oop.streams;

import java.util.List;
import java.util.stream.Collectors;

public class Example5b {

	public static void main(String[] args) {
		List<Student> students = StudentData.loadCN();
		
		String lastNames = students
							.stream()
							.filter(s -> s.getPoints() > 30)
							.map(s -> s.getLastName())		
							.sorted()
							.collect(Collectors.joining(", "));
		
		
		System.out.println(lastNames);	
	}
	
}
