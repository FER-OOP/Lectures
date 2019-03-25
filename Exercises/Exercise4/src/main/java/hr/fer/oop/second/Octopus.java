package hr.fer.oop.second;

import hr.fer.oop.fourth.SeaSpecies;

/**
 * @author OOP
 */
public class Octopus extends SeaAnimal{

	public Octopus() {
		super(SeaSpecies.CEPHALOPOD);
	}
	@Override
	public void wayOfMovement() {
		System.out.println("Octopus uses jet propulsion to swim.");
	}

}
