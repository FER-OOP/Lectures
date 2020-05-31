package hr.fer.oop.streams;

import java.text.Collator;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Example5 {

	public static void main(String[] args) {
		List<Student> students = StudentData.load();
		Comparator<Object> comp = Collator.getInstance(Locale.CHINA);

		// using anonymous class
		List<String> lastNames = students.stream()
		  .filter(new Predicate<Student>() {
			@Override
			public boolean test(Student t) {
				return t.getPoints() > 30;
			}
		   })
		  .map(new Function<Student, String>() {
			  @Override
			  public String apply(Student t) {
				return t.getLastName();
			}
		  })	
		  .sorted(comp)
		  .collect(Collectors.toList());
		
		//print new collection
		lastNames.stream().forEach(t -> System.out.println(t));
		System.out.println("-------------");

		// using lambda:
		lastNames = students
			.stream()
			.filter(s -> s.getPoints() > 30)
			.map(s -> s.getLastName())		
			.sorted(comp)
			.collect(Collectors.toList());
		
		
		//print new collection 
		lastNames.stream()				  
				 .forEach(t -> System.out.println(t));		
	}
	
}
