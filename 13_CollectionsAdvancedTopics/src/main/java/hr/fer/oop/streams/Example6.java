package hr.fer.oop.streams;

import java.util.List;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;

public class Example6 {

	public static void main(String[] args) {
		List<Student> students = StudentData.load();

		// using anonymous class
		double avgGrade = students.stream()
		  .filter(new Predicate<Student>() {
			@Override
			public boolean test(Student t) {
				return t.getFinalGrade()>2;
			}
		   })
		  .mapToInt(new ToIntFunction<Student>() {
			  @Override
			public int applyAsInt(Student student) {
				return student.getFinalGrade();
			}
		  })
		  .average()
		  .getAsDouble();
		System.out.format("Average grade %.2f%n", avgGrade);

		// using lambda
		double avgGrade2 = students
			.stream()
			.filter(s -> s.getFinalGrade()>2)
			.mapToInt(s -> s.getFinalGrade())
			.average()
			.getAsDouble();		
		System.out.format("Average grade %.2f%n", avgGrade2);
	}
	
}
