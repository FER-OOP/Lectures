package hr.fer.oop.lab3.demo;

import hr.fer.oop.lab3.FootballPlayer;
import hr.fer.oop.lab3.SimpleFootballPlayerCollectionImpl;
import hr.fer.oop.lab3.welcomepack.PlayingPosition;
import hr.fer.oop.lab3.welcomepack.SimpleFootballPlayerCollection;

public class SimpleFootbalPlayerCollectionTest {

	public static void main(String[] args) {

		final int TEST_MAX_SIZE = 10;
		SimpleFootballPlayerCollection collection = new SimpleFootballPlayerCollectionImpl(TEST_MAX_SIZE);

		if (collection.size() != 0) {
			System.err.println("TEST FAILED: Collection should be empty!");
		}

		for (int i = 0; i < 2 * TEST_MAX_SIZE; i++) {
			FootballPlayer sequentialPlayer = new FootballPlayer("NAME" + i, "", 1, 1, PlayingPosition.GK);
				collection.add(sequentialPlayer);
		}
		if(collection.size() > TEST_MAX_SIZE){
			System.err.printf("TEST FAILED: Collection should not exceed max size: %d!%n", TEST_MAX_SIZE);
		}

		collection.clear();
		if(collection.size() != 0){
			System.err.println("TEST FAILED: Collection should be empty after clear method!");
		}


		System.out.println("Ensure there are no 'TEST FAILED' messages before this message, and then write own tests.");
	}

}
