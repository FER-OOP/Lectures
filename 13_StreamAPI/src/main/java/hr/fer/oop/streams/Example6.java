package hr.fer.oop.streams;

import java.util.List;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;

public class Example6 {

	public static void main(String[] args) {
		List<Student> students = StudentData.load();
		int threshold = 20;
		// using anonymous class
		double avgGrade = students.stream()
		  .filter(new Predicate<Student>() {
			@Override
			public boolean test(Student t) {
				return t.getPoints() > threshold;
			}
		   })
		  .mapToInt(new ToIntFunction<Student>() {
			  @Override
			public int applyAsInt(Student student) {
				return student.getPoints();
			}
		  })
		  .average()
		  .getAsDouble();
		System.out.format("Average points for students above threshold %.2f%n", avgGrade);

		// using lambda
		double avgGrade2 = students
			.stream()
			.filter(s -> s.getPoints() > threshold)
			.mapToInt(s -> s.getPoints())
			.average()
			.getAsDouble();		//warning: throws Exception if no data => use .ifPresent or .ifPresentOrElse instead
		System.out.format("Average points for students above threshold %.2f%n", avgGrade2);
	}
	
}
