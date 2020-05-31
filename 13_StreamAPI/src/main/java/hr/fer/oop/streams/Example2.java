package hr.fer.oop.streams;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Example2 {

	public static void main(String[] args) {
		List<Student> students = StudentData.load();

		// using anonymous class
		students.stream()
		  .filter(new Predicate<Student>() {
			@Override
			public boolean test(Student t) {
				return t.getFinalGrade()==5;
			}
		   })
		  .forEach(new Consumer<Student>() {
			@Override
			public void accept(Student t) {
				System.out.println(t);
			}
		});

		System.out.println();
		
		// using lambda
		students.stream()
				.filter(s -> s.getFinalGrade()==5)
				.forEach(t -> System.out.println(t));
	}
	
}
