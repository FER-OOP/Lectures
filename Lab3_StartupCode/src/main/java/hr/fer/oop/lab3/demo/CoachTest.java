package hr.fer.oop.lab3.demo;

import hr.fer.oop.lab3.Coach;
import hr.fer.oop.lab3.FootballPlayer;
import hr.fer.oop.lab3.NationalTeam;
import hr.fer.oop.lab3.welcomepack.*;

public class CoachTest {
	public static final String[] PLAYER_NAMES = { "Pilkotesa", "R Vokac", "Smitac", "D Misic", "Dolso", "Narij",
			"Nastic", "Prekinoski", "N Vokac", "Kuser", "Kobsic" };
	public static final PlayingPosition[] PLAYER_POSITIONS = { PlayingPosition.GK, PlayingPosition.DF,
			PlayingPosition.DF, PlayingPosition.DF, PlayingPosition.MF, PlayingPosition.MF, PlayingPosition.MF,
			PlayingPosition.MF, PlayingPosition.MF, PlayingPosition.FW, PlayingPosition.FW };
	public static final int PLAYERS_SIZE = 11;
	public static final int DEF_EMOTION = 80;
	public static final int DEF_SKILL = 85;

	public static final String DEF_COUNTRY = "Croatia";

	public static void main(String[] args) {

		Coach defaultCoach = new Coach(Constants.DEFAULT_PLAYER_NAME, Constants.DEFAULT_COUNTRY);
		defaultCoach.setCoachingSkill(10);
		Coach defaultCoach2 = new Coach(Constants.DEFAULT_PLAYER_NAME, Constants.DEFAULT_COUNTRY);
		defaultCoach2.setEmotion(20);
		
		if (!defaultCoach.equals(defaultCoach2)) {
			System.err.println("TEST FAILED:  defaultCoach should be equal to defaultCoach2");
		}
		
		Coach mainCoach = new Coach("Main", Constants.DEFAULT_COUNTRY, 1, 1, Formation.F352());
		
		if (mainCoach.equals(defaultCoach)) {
			System.err.println("TEST FAILED:  Main coach should be different");
		}	
		
		Coach wrongCoach = new Coach(Constants.DEFAULT_PLAYER_NAME, Constants.DEFAULT_COUNTRY, -5, 150, Formation.F541());
		if(wrongCoach.getEmotion() <0 || wrongCoach.getCoachingSkill() > 100){
			System.err.println("TEST FAILED: Coach values are not correct!");
		}

		FootballPlayer notEligiblePlayer = new FootballPlayer("Butatista", "Argentina", 65, 83, PlayingPosition.FW);

		Manager nationalManager = new Coach("Ban Vasten", "Dutch", 66, 70, Formation.F442());

		NationalTeam croatia = new NationalTeam("Croatia", Formation.F352());
		nationalManager.setManagingTeam(croatia);

		// add player that is not eligible for national team
		croatia.registerPlayer(notEligiblePlayer);
		
		// create and register player:
		for (int i = 0; i < PLAYERS_SIZE; i++) {
			croatia.registerPlayer(new FootballPlayer(PLAYER_NAMES[i], DEF_COUNTRY, DEF_EMOTION, DEF_SKILL, PLAYER_POSITIONS[i]));
		}
		


		SimpleFootballPlayerCollection croatianSquad = croatia.getRegisteredPlayers();
		System.out.println("Printing national team, not eligible player should not be included..., i.e. Butatista should not be listed here...");
		printPlayerNames(croatianSquad);

		nationalManager.pickStartingEleven();
		System.out.println("Starting eleven:");
		printPlayerNames(croatia.getStartingEleven());


		System.out.println("Manager is setting his formation (442)");
		nationalManager.forceMyFormation();
		nationalManager.pickStartingEleven();
		System.out.println(
				"Missing a defender, number of player in the starting eleven: " + croatia.getStartingEleven().size());


		System.out.println("Ensure there are no 'TEST FAILED' messages before this message, and then write own tests.");

	}

	public static void printPlayerNames(SimpleFootballPlayerCollection players) {
		String output = "";
		for (FootballPlayer player : players.getPlayers()) {
			if(player!=null)
			output += player.getName() + "\n";
		}
		System.out.println(output);
	}
}
