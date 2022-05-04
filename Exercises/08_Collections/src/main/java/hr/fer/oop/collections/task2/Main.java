package hr.fer.oop.collections.task2;

public class Main {

	public static void main(String[] args) {
		JavelinScores js = new JavelinScores();

		js.add("Sara", 68.43);
		js.add("Sara", 66.18);
		js.add("Steffi", 68.34);
		js.add("Sara", 62.18);
	
		js.printScores();
		
		System.out.println();
		
		js.printBest();
	}

}
