package hr.fer.oop.lab3.demo;

import hr.fer.oop.lab3.FootballPlayer;
import hr.fer.oop.lab3.NationalTeam;
import hr.fer.oop.lab3.welcomepack.Constants;
import hr.fer.oop.lab3.welcomepack.PlayingPosition;

public class NationalTeamTest {

	public static void main(String[] args) {

		final double DELTA = 0.001;
		NationalTeam croatia = new NationalTeam("Croatia");

		FootballPlayer player = new FootballPlayer("Player-Cro1", "Croatia", PlayingPosition.MF);
		croatia.registerPlayer(player);
		if (!croatia.isPlayerRegistered(player)) {
			System.err.println("TEST FAILED: Domestic player should be registered for the national team!");
		}

		FootballPlayer foreignPlayer = new FootballPlayer("Der Spieler", "Germany", 1, 1, PlayingPosition.DF);
		croatia.registerPlayer(foreignPlayer);
		if (croatia.isPlayerRegistered(foreignPlayer)) {
			System.err.println("TEST FAILED: This player cannot be registered for the national team");
		}

		NationalTeam ratingTeam = new NationalTeam(Constants.DEFAULT_COUNTRY);
		for (int i = 0; i < 20; i++) {
			FootballPlayer sequentialPlayer = new FootballPlayer("NAME" + i, Constants.DEFAULT_COUNTRY, 10, 100,
					PlayingPosition.GK);
			ratingTeam.registerPlayer(sequentialPlayer);
		}
		double expected = (10 * Constants.SEVENTY_PERCENT + 100 * Constants.THIRTY_PERCENT) * 20;
		if (Math.abs(ratingTeam.calculateRating() - expected) > DELTA) {
			System.err.println("TEST FAILED: Team rating is not correct");
		}


		System.out.println("Ensure there are no 'TEST FAILED' messages before this message, and then write own tests.");

	}

}
