package hr.fer.oop.first;

import hr.fer.oop.fifth.AnimalType;
import hr.fer.oop.third.MakeSound;

/**
 * @author OOP
 */
public class Lion extends Animal implements MakeSound{
	
	public Lion() {
		this.setType(AnimalType.EARTH);
	}
	
	@Override
	public void introduceYourself() {
		System.out.println("I am a lion.");
	}

	@Override
	public void makeSound() {
		System.out.println("The lion roars.");
		
	}
}
