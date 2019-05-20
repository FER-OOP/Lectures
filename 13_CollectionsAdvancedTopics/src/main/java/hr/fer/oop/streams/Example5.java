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

		// using anonymous class
		List<String> lastNames = students.stream()
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
		lastNames.stream().forEach(t -> System.out.println(t));
		System.out.println("-------------");

		// using lambda:
		lastNames = students
			.stream()
			.filter(s -> s.getFinalGrade()>3)
			.map(s -> s.getLastName())			
			.collect(Collectors.toList());
		
		Comparator<Object> comp = Collator.getInstance(Locale.forLanguageTag("hr"));
		//print new collection (but sorted) 
		lastNames.stream()
				  .sorted(comp)
				 //.sorted()
				 .forEach(t -> System.out.println(t));
		System.out.println("-------------");
		lastNames.stream()		  
		 .forEach(t -> System.out.println(t));	
	}
	
}
