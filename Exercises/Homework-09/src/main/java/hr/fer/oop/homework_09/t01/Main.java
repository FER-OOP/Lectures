package hr.fer.oop.homework_09.t01;

public class Main {

	public static void main(String[] args) {		
		Ladder ladder = new Ladder("Brian", "Mia", "Sophia", "John");
		ladder.join("Charlotte", "Pierre", "Bruno");
		print(ladder.standings());
		
		ladder.gameFinished("Mia", "John");
		System.out.println("Mia won John");		
		print(ladder.standings());
		
		ladder.gameFinished("Bruno", "Brian");
		System.out.println("Bruno won Brian");
		print(ladder.standings());
		
		ladder.gameFinished("Charlotte", "Brian");
		System.out.println("Charlotte won Brian");
		print(ladder.standings());
		
		ladder.gameFinished("Mia", "John");
		System.out.println("Mia won John");
		print(ladder.standings());
		
		ladder.gameFinished("Sophia", "John");
		System.out.println("Sophia won John");
		print(ladder.standings());		
	}

	private static void print(Iterable<String> standings) {
		int pos=0;
		for(String player : standings) {
			System.out.format("%d. %s%n", ++pos, player);
		}
		System.out.println();
		
	}

}
