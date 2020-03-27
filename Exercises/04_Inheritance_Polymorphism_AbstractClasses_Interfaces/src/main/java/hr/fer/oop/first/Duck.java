package hr.fer.oop.first;

/**
 * @author OOP
 */
public class Duck extends Animal implements MakeSound{

	@Override
	public void introduceYourself() {
		System.out.println("I am a duck.");
	}

	@Override
	public void makeSound() {
		System.out.println("The duck quacks.");		
	}
}
