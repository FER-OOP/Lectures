package hr.fer.oop.first;

/**
 * @author OOP
 */
public class Lion extends Animal implements MakeSound{
	
	@Override
	public void introduceYourself() {
		System.out.println("I am a lion.");
	}

	@Override
	public void makeSound() {
		System.out.println("The lion roars.");
		
	}
}
