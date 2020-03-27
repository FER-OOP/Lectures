package hr.fer.oop.third;

import hr.fer.oop.first.Duck;
import hr.fer.oop.first.Lion;

/**
 * @author OOP
 */
public class Main {

	public static void main(String[] args) {
		Duck d = new Duck();
		d.introduceYourself();
		d.makeSound();
		
		Lion l = new Lion();
		l.introduceYourself();
		l.makeSound();
		
	}

}
