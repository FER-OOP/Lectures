package hr.fer.oop.streams;

import java.util.List;

public class Example6b {

	public static void main(String[] args) {
		List<Student> students = StudentData.load();
		int threshold = 20;
		students
			.stream()
			.filter(s -> s.getPoints() > threshold)
			.mapToInt(s -> s.getPoints())
			.average()
			.ifPresentOrElse(avg -> System.out.printf("Average points for students above threshold %.2f%n", avg),
							() -> System.out.println("Stream contains no data"));					
	}
	
}
