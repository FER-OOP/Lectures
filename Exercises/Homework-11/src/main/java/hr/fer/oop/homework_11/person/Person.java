package hr.fer.oop.homework_11.person;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Person {
	private int id;
	private String name;
	private String surname;
	private LocalDate birthday;
	private Gender gender;
		
	public Person(int id, String name, String surname, LocalDate birthday, Gender gender) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.birthday = birthday;
		this.gender = gender;
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getSurname() {
		return surname;
	}
	public LocalDate getBirthday() {
		return birthday;
	}
	public Gender getGender() {
		return gender;
	}
	public int getAge() {
		return java.time.Period.between(birthday, LocalDate.now()).getYears();	
	}	
	@Override
	public String toString() {
		return "Person [id =" + id + ", name=" + name + ", lastName=" + surname + ", birthday=" + birthday + ", gender="
				+ gender + "]";
	}
	
	public static List<Person> loadPersons(){
		List<Person> list = new ArrayList<>();
		list.add(new Person(1, "Dragec", "Vragec", LocalDate.of(1958, 4, 28),Gender.MALE));
		list.add(new Person(2, "Sonja", "Vragec", LocalDate.of(1965, 3, 3),Gender.FEMALE));
		list.add(new Person(3, "Pero", "Vragec", LocalDate.of(1961, 12, 25),Gender.MALE));
		list.add(new Person(4, "Mazalo", "Vragec", LocalDate.of(1963, 2, 21),Gender.MALE));
		list.add(new Person(5, "Cobra", "Vragec", LocalDate.of(1966, 12, 1),Gender.MALE));
		list.add(new Person(6, "Stefek", "Vragec", LocalDate.of(1970, 7, 10),Gender.MALE));
		list.add(new Person(7, "Buco", "Vragec", LocalDate.of(1975, 9, 15),Gender.MALE));
		return list;
	}
		
}
