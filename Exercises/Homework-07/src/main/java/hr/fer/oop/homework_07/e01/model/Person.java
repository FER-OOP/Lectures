package hr.fer.oop.homework_07.e01.model;

public class Person {

	private String name;
	private String surname;

	public Person(String name, String surname) {
		super();
		this.name = name;
		this.surname = surname;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", surname=" + surname + "]";
	}

}
