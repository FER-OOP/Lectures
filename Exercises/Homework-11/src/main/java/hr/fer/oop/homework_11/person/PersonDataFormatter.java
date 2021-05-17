package hr.fer.oop.homework_11.person;

@FunctionalInterface
public interface PersonDataFormatter {
	String format(Person p);  // mapper! 
	
	default void print(Person person) {
		System.out.println(format(person));
	}
	
	//solution: entering a code into the print method
	static void printAll(Iterable<Person> persons, PersonDataFormatter formatter) {
		for(Person person : persons)
			System.out.format("%s\n", formatter.format(person));
	}
}
