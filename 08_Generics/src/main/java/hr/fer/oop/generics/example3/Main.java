package hr.fer.oop.generics.example3;

public class Main {
	public static void main(String[] args) {
		Pair<Integer> iPair = new Pair<>(5, 5);
		Pair<String> sPair = new Pair<>("A", "B");
		
		iPair.printWith(sPair);
		iPair.printWith("OOP");
		
		iPair.printWithPair(sPair);
		iPair.printWithPair(iPair);
		//iPair.printWithPoint("OOP"); //compile error
	}
}
