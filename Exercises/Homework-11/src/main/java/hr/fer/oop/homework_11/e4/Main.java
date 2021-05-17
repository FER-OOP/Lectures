package hr.fer.oop.homework_11.e4;

import java.util.List;
import hr.fer.oop.homework_11.person.Person;
import hr.fer.oop.homework_11.person.PersonDataFormatter;

public class Main {

	public static void main(String[] args) {

		List<Person> persons = Person.loadPersons();

		PersonDataFormatterImpl allDataFormatter = new PersonDataFormatterImpl();
		PersonDataFormatter.printAll(persons, allDataFormatter);
		System.out.println();

		PersonDataFormatter.printAll(persons, new PersonDataFormatter() {
			@Override
			public String format(Person person) {	
				return String.format("%s %s %d", person.getName(), 
						person.getSurname().toUpperCase(), person.getAge());
			}
		}
		);
		System.out.println();

		PersonDataFormatter nameAndBirthdayformatter = new PersonDataFormatter() {
			@Override
			public String format(Person p) {
				return String.format("%s was born %s", p.getName(),p.getBirthday());
			}
			
		};
		
		
		PersonDataFormatter.printAll(persons, nameAndBirthdayformatter);
		System.out.println();
		nameAndBirthdayformatter.print(persons.get(0));
		System.out.println();

		// because PersonDataFormater is a functional interface, lambdas and function references
		// can be used instead of classes that implement PersonDataFormater; boilerplate code removed
		PersonDataFormatter lambdaFormatter = (Person p)-> { 
											return String.format("%s was born %s", p.getName(),p.getBirthday());
										};
		
		lambdaFormatter = (p)-> String.format("%s was born %s", p.getName(), p.getBirthday());
		
		PersonDataFormatter.printAll(persons, lambdaFormatter);
		System.out.println();
		
		PersonDataFormatter.printAll(persons, Person::toString);
		System.out.println();
		PersonDataFormatter.printAll(persons, Main::aMethod);
		
	}

	
	// Surprisingly, a static method whose signature is equal to the signature of the abstract method 
	// of the functional interface PersonDataFormatter accidentally exists here :)
	public static String aMethod(Person p) {
		return  "My name is " + p.getName() + " " + p.getSurname() + " and I am " + p.getAge() + " years old.";
	}
	
}
