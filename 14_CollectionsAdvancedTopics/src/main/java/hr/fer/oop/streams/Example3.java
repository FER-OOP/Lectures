package hr.fer.oop.streams;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Example3 {

	public static void main(String[] args) {
		List<Student> students = StudentData.load();

		// using anonymous class
		List<String> studentIDs = students.stream()
		  .filter(new Predicate<Student>() {
			@Override
			public boolean test(Student t) {
				return t.getFinalGrade()>3;
			}
		   })
		  .map(new Function<Student, String>() {
			  @Override
			  public String apply(Student t) {
				return t.getLastName();
			}
		  })		  
		  .collect(Collectors.toList());
		
		//print new collection
		studentIDs.stream().forEach(t -> System.out.println(t));
		System.out.println();

		// using lambda:
		List<String> studentIDs2 = students
			.stream()
			.filter(s -> s.getFinalGrade()>3)
			.map(s -> s.getLastName())			
			.collect(Collectors.toList());
		
		//print new collection 
		studentIDs2.stream().forEach(t -> System.out.println(t));		
	}
	
}
