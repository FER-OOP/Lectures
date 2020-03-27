package hr.fer.oop.second;

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
