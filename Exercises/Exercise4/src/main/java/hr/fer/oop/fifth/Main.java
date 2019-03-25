package hr.fer.oop.fifth;

import hr.fer.oop.first.Animal;
import hr.fer.oop.first.Lion;
import hr.fer.oop.second.Octopus;

/**
 * @author OOP
 */
public class Main {

	public static void main(String[] args) {
		Lion l = new Lion();
		Octopus o = new Octopus();
		
		
		versus(o,l);
	}
	
	public static void versus(Animal x, Animal y) {
		AnimalType winner = x.getType().winner(y.getType());
		if (x.getType() == winner && y.getType() == winner)
			System.out.println("Same type battle.");
		else if(x.getType() == winner) {
			System.out.println("Winner introduction: ");
			x.introduceYourself();
		}
		else {
			System.out.println("Winner introduction: ");
			y.introduceYourself();
		}
	}

}
