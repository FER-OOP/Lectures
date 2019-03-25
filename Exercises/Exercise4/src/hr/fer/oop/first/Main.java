package hr.fer.oop.first;

/**
 * @author OOP
 */
public class Main {

	public static void main(String[] args) {
		Animal animal = new Animal();
		animal.introduceYourself();
		Lion l = new Lion();
		l.introduceYourself();
		animal = new Duck();
		animal.introduceYourself();
	}

}

