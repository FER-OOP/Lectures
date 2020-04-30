package hr.fer.oop.pred.kolekcije.av.zad2;

import java.util.*;

public class JavelinScores {

	List<Score> scoreList;
	Set<Score> scoreSet;
	
	public JavelinScores() {
		scoreList = new LinkedList<>();
		scoreSet = new TreeSet<Score>();
	}
	
	public void add(String name, double score) {
		Score s = new Score(name, score);
		int i;
		for (i=0; i<scoreList.size(); i++) {
			if (score > scoreList.get(i).getScore())
				break;
		}
		scoreList.add(i, s);
	}
	
	public void addSet(String name, double score) {
		scoreSet.add(new Score(name, score));
	}
	
	public void print() {
		for (Score s : scoreList)
			System.out.println(s);
	}
	
	public void printSet() {
		for (Score s : scoreSet)
			System.out.println(s);
	}
	
	public void printBest() {
		var printed = new HashSet<String>(); // pomoæni set
		for (Score score : scoreSet) {
			//pokušamo ubaciti name u printed
			if (printed.add(score.getName()))
				System.out.println(score);
		}
	}
	
	
	public static void main(String[] args) {
		//Sara 68.43 ; Sara 66.18 ; Steffi 68.34
		
		JavelinScores js = new JavelinScores();
//		js.add("Sara", 68.43);
//		js.add("Sara", 66.18);
//		js.add("Steffi", 68.34);
//		
//		js.print();
		
		js.addSet("Sara", 68.43);
		js.addSet("Sara", 66.18);
		js.addSet("Steffi", 68.34);
		js.addSet("Sara", 62.18);
	
		js.printSet();	
		System.out.println();
		js.printBest();
		
	}

}
