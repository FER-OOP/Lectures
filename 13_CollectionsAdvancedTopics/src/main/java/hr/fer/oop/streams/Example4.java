package hr.fer.oop.streams;

import java.util.List;

public class Example4 {

	public static void main(String[] args) {
		List<Student> students = StudentData.load();
		//print sorted by last name
		System.out.println("---Students with grade 5, sorted---");
		students.stream()
				.filter(s -> s.getFinalGrade() == 5)
				.sorted(Student.BY_LAST_NAME)
				.forEach(t -> System.out.println(t));
		//print again (proof that collection is not modified)
		System.out.println("---All students---");
		students.stream()		
				.forEach(t -> System.out.println(t));
	}	
}
