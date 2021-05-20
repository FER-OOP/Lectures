package hr.fer.oop.streams;

import java.util.List;
import java.util.function.Consumer;

public class Example1 {

	public static void main(String[] args) {
		List<Student> students = StudentData.load();

		// using anonymous class
		students.stream().forEach(new Consumer<Student>() {
			@Override
			public void accept(Student t) {
				System.out.println(t);
			}
		});
		
		System.out.println();
		// using lambda
		students.stream().forEach(t -> System.out.println(t));
		
		//or 
		//students.stream().forEach(System.out::println);
	}	
}
