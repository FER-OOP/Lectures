package hr.fer.oop.second;

import hr.fer.oop.first.Animal;

/**
 * @author OOP
 */
public class Main {

	public static void main(String[] args) {
		Animal a = new Octopus();
		a.introduceYourself();
		//notice that we cannot write a.wayOfMovement()
		SeaAnimal b = new Octopus();
		b.introduceYourself();
		b.wayOfMovement();		
		Fish c = new Fish();
		c.introduceYourself();
		c.wayOfMovement();
	}
}
