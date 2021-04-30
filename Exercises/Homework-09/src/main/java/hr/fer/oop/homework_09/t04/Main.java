package hr.fer.oop.homework_09.t04;

import hr.fer.oop.homework_09.t03.LadderEnhanced;

public class Main {

	public static void main(String[] args) {		
		LadderEnhancedByLossesOrder ladder = new LadderEnhancedByLossesOrder("Brian", "Mia", "Sophia", "John", "Charlotte", "Pierre", "Bruno");		
		ladder.gameFinished("Mia", "John");
		ladder.gameFinished("Bruno", "Brian");
		ladder.gameFinished("Charlotte", "Brian");
		ladder.gameFinished("Mia", "John");
		ladder.gameFinished("Sophia", "John");	
		
		printStandings(ladder);
		
		printByLosses(ladder);
		
	}

	private static void printStandings(LadderEnhanced ladder) {
		int pos=0;
		for(String player : ladder.standings()) {
			System.out.format("%d. %s has %d wins and %d losses %n", ++pos, player, 
					ladder.wins(player), ladder.losses(player));
		}
		System.out.println();		
	}
	
	private static void printByLosses(LadderEnhancedByLossesOrder ladder) {
		int pos=0;
		for(String player : ladder.orderByLosses()) {
			System.out.format("%d. %s has %d losses %n", ++pos, player, ladder.losses(player));
		}
		System.out.println();		
	}

}
