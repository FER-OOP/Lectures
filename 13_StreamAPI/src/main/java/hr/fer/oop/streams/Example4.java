package hr.fer.oop.streams;

import java.util.List;

public class Example4 {

	public static void main(String[] args) {
		List<Student> students = StudentData.load();
		//print sorted by last name
		System.out.println("---Students with  40 points or more, sorted by last name---");
		students.stream()
				.filter(s -> s.getPoints() >= 40)
				.sorted(Student.BY_LAST_NAME)				
				.forEach(t -> System.out.println(t));
		//print again (proof that collection is not modified)
		System.out.println("---All students---");
		students.stream()		
				.forEach(t -> System.out.println(t));
	}	
}
