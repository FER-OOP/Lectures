package hr.fer.oop.homework_04.e05;

import hr.fer.oop.homework_04.e03.Person;
import hr.fer.oop.homework_04.e04.*;

public class MainClass {

	public static void main(String[] args) {
		
		Person[] people = new Person[5];
		
		people[0] = new Teacher("Dario", "Tušek", 42, "dario.tusek@fer.hr", "OOP", 10000);
		people[1] = new Teacher("Doris", "Bezmalinović", 43, "doris.bezmalinovic@fer.hr", "OOP", 10000);
		people[2] = new Teacher("Perica", "Bebić", 35, "perica.bebic@fer.hr", "OOP", 9400);
		
		people[3] = new Student("Janko", "Horvat", 18, "0036312123", (short)1);
		people[4] = new Student("Ana", "Kovač", 20, "0036387656", (short)2);

		double sum = 0;
		int count = 0;
		
		for (Person p : people) {
			System.out.println(p.getName() + " " + p.getSurname());
			if (p instanceof Teacher) {
				sum+= ((Teacher)p).getSalary();
				count++;
			}			
		}
		
		if (count>0)
			System.out.println("Average salary of " + count + " teachers is: " + sum/count);
		
		//test
		test();
	}

	public static void test() {
		
		Person p1 = new Person("Ivo","Ivic", 20);
		Person p2 = new Person("Ivo","Ivic", 20);
		Person p3 = new Student("Ivo","Ivic", 20, "0036312123", (short)3);
		Person p4 = new Student("Marko","Mariæ", 25, "0036312123", (short)5);
		
		System.out.println(p1.equals(p2));		
		System.out.println(p1.equals(p3));
		System.out.println(p3.equals(p4));
		
	}
	
	
}
