package hr.fer.oop.second;

import hr.fer.oop.fifth.AnimalType;
import hr.fer.oop.first.Animal;
import hr.fer.oop.fourth.SeaSpecies;

/**
 * @author OOP
 */
public abstract class SeaAnimal extends Animal{

	private SeaSpecies species;
	
	public SeaAnimal(SeaSpecies species) {
		this.species = species;
		this.setType(AnimalType.SEA);
	}
	public abstract void wayOfMovement();
	
	public void printSpecies() {
		System.out.println(this.species);
	}	
	@Override
	public final void introduceYourself() {
		System.out.println("I am a sea animal. I cannot introduce myself.");
	}	
}
