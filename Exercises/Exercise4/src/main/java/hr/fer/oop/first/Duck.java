package hr.fer.oop.first;

import hr.fer.oop.fifth.AnimalType;
import hr.fer.oop.third.MakeSound;

/**
 * @author OOP
 */
public class Duck extends Animal implements MakeSound{

	public Duck() {
		this.setType(AnimalType.EARTH);
	}
	
	@Override
	public void introduceYourself() {
		System.out.println("I am a duck.");
	}

	@Override
	public void makeSound() {
		System.out.println("The duck quacks.");		
	}
}
