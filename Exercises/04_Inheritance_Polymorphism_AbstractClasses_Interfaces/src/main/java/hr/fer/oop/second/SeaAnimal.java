package hr.fer.oop.second;

import hr.fer.oop.first.Animal;

/**
 * @author OOP
 */
public abstract class SeaAnimal extends Animal{

	private SeaSpecies species;
	
	protected SeaAnimal(SeaSpecies species) {
		this.species = species;
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
