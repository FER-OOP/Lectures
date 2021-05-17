package hr.fer.oop.homework_11.e3;

import java.util.List;
import hr.fer.oop.homework_11.person.Person;


public class Main {

	public static void main(String[] args) {

		List<Person> persons = Person.loadPersons();
		printAllData(persons); 										
		System.out.println();
		printNameSurnameUpperWithAge(persons); 						
		System.out.println();
		printNameGenderAgeForPersonsYoungerThan(persons, 55);
	}

	public static void printAllData(Iterable<Person> persons) {
		for(Person person : persons)
				System.out.format("%s %s %s %s %d%n", person.getName(), 
						person.getSurname(), person.getBirthday(), person.getGender(), person.getAge());
	}
	public static void printNameSurnameUpperWithAge(Iterable<Person> persons) {
		for(Person person : persons)
				System.out.format("%s %s %d%n", person.getName(), 
						person.getSurname().toUpperCase(), person.getAge());
	}
	public static void printNameGenderAgeForPersonsYoungerThan(Iterable<Person> persons, int ageLimit) { 
		for(Person person : persons) {
		    if(person.getAge() < ageLimit)
		    	System.out.format("%s %s %d%n", person.getName(), person.getGender(), person.getAge());
		}	
	}
	
	// ...  never ending story
	
}
