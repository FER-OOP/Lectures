package hr.fer.oop.homework_11.e5;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import hr.fer.oop.homework_11.person.Person;
import hr.fer.oop.homework_11.person.Gender;

public class Main {

	public static void main(String[] args) {

		List<Person> persons = Person.loadPersons();
		List<Person> ladies = new ArrayList<>();
		
		printPersons(persons, (p)-> p.getAge() < 55, (p)-> p.getName() + ", " + p.getAge());  // A
		System.out.println();
		printPersons(persons, (p)-> p.getGender() == Gender.FEMALE, Person::toString);
		System.out.println();
		
		processPersons(persons, (p)-> p.getAge() < 55, (p)-> System.out.println(p.getName() + ", " + p.getAge())); // as A
		System.out.println();
		processPersons(persons, (p)-> p.getGender() == Gender.FEMALE, (p)-> ladies.add(p));   // B
		processPersons(ladies, (p)-> true, (p)-> System.out.println(p.getName() + ", " + ladies.size()));
		System.out.println();
		
		processData(persons, (p)-> p.getAge() < 55, (p)-> p.getName() + ", " + p.getAge(),
										/*(String s) -> System.out.println(s)*/ System.out::println);  // as A
		processData(persons, (p)-> p.getGender() == Gender.FEMALE, (p)-> p, (p)-> ladies.add(p));  // as B
		
	}
	
	public static void printPersons(Iterable<Person> persons, Predicate<Person> criteria,
									Function<Person, String> formatter) { 
		for (Person p : persons) 
	        if (criteria.test(p)) 
	            System.out.format("%s\n", formatter.apply(p));
	}
	
	public static void processPersons(Iterable<Person> persons, Predicate<Person> criteria, 
				                    Consumer<Person> action) {
		for (Person p : persons) 
			 if (criteria.test(p)) 
			      action.accept(p);
	}
		
	public static <T, R> void processData(Iterable<T> data, Predicate<T> criteria,
											  Function <T, R> mapper, Consumer<R> action) {
		for (T p : data) {
		      if (criteria.test(p)) {
		            R result = mapper.apply(p);
		            action.accept(result);
		      }
		}
	}	
	
}
