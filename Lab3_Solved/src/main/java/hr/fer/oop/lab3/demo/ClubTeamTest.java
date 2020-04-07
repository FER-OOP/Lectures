package hr.fer.oop.lab3.demo;

import hr.fer.oop.lab3.ClubTeam;
import hr.fer.oop.lab3.FootballPlayer;
import hr.fer.oop.lab3.welcomepack.Constants;
import hr.fer.oop.lab3.welcomepack.PlayingPosition;

public class ClubTeamTest {

	public static void main(String[] args) {

		final double DELTA = 0.001;
		ClubTeam defaultTeam = new ClubTeam("Some irrelevant name");

		defaultTeam.setReputation(-1);
		if(defaultTeam.getReputation() != Constants.DEFAULT_REPUTATION){
			System.err.println("TEST FAILED: Reputation is out for range!");
		}
		defaultTeam.setReputation(101);
		if(defaultTeam.getReputation() != Constants.DEFAULT_REPUTATION){
			System.err.println("TEST FAILED: Reputation is out for range!");
		}
		
		FootballPlayer player = new FootballPlayer(Constants.DEFAULT_PLAYER_NAME, Constants.DEFAULT_COUNTRY, PlayingPosition.FW);
		defaultTeam.registerPlayer(player);
		if (!defaultTeam.isPlayerRegistered(player)) {
			System.err.println("TEST FAILED: Player should be registered in defaultTeam!");
		}

		FootballPlayer unskilledPlayer = new FootballPlayer("Slacker", Constants.DEFAULT_COUNTRY, 1, 1,
				PlayingPosition.DF);
		defaultTeam.registerPlayer(unskilledPlayer);
		if (defaultTeam.isPlayerRegistered(unskilledPlayer)) {
			System.err.println("TEST FAILED: Player should not be registered in defaultTeam!!");
		}

		ClubTeam reputationTeam = new ClubTeam("Another name");
		for (int i = 0; i < 20; i++) {
			FootballPlayer sequentialPlayer = new FootballPlayer("NAME" + i, Constants.DEFAULT_COUNTRY, 10, 100,
					PlayingPosition.GK);
			reputationTeam.registerPlayer(sequentialPlayer);
		}
		double expected = (10 * Constants.THIRTY_PERCENT + 100 * Constants.SEVENTY_PERCENT) * 20;
		if (Math.abs(reputationTeam.calculateRating() - expected) > DELTA) {
			System.err.println("TEST FAILED: Team rating is not correct!!");
		}


		System.out.println("Ensure there are no 'TEST FAILED' messages before this message, and then write own tests.");

	}
}
