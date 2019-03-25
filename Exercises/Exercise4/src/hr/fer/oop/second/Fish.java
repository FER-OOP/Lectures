package hr.fer.oop.second;

import hr.fer.oop.fourth.SeaSpecies;

/**
 * @author OOP
 */
public class Fish extends SeaAnimal{

	public Fish() {
		super(SeaSpecies.FISH);
	}
	@Override
	public void wayOfMovement() {
		System.out.println("The fish uses fins to swim.");
	}
}
