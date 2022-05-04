package hr.fer.oop.collections.task2;

import java.util.*;

public class JavelinScores {

	private List<Score> scores;
	
	public JavelinScores() {
		scores = new LinkedList<>();
	}
	
	public void add(String name, double score) {
		Score s = new Score(name, score);
		int i;
		for (i=0; i<scores.size(); i++) {
			if (score > scores.get(i).getScore())
				break;
		}
		scores.add(i, s);
	}
	
	public void printScores() {
		for (Score s : scores)
			System.out.println(s);
	}

	
	public void printBest() {
		var printed = new HashSet<String>(); 
		for (Score score : scores) {
			if (printed.add(score.getName()))
				System.out.println(score);
		}
	}
}
