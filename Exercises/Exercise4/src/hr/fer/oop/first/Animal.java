package hr.fer.oop.first;

import hr.fer.oop.fifth.AnimalType;

/**
 * @author OOP
 */
public class Animal {

	private AnimalType type;
	
	public AnimalType getType() {
		return type;
	}

	public void setType(AnimalType type) {
		this.type = type;
	}

	public void introduceYourself() {
		System.out.println("I am an animal.");
	}
}
