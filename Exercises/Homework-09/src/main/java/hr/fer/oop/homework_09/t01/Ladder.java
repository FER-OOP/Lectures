package hr.fer.oop.homework_09.t01;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Ladder {
	private List<String> players = new LinkedList<>();
	
	public Ladder(String...players) {
		join(players);
	}
		
	public void join(String... players) {
		for(String player : players) {
			if (!this.players.contains(player)) //use additional Hashset when number of players is large
				this.players.add(player);
		}
	}		
	
	public void gameFinished(String winner, String looser) {		
		int winner_pos = players.indexOf(winner);
		int looser_pos = players.indexOf(looser);
								
		if (winner_pos < looser_pos) {
			if (winner_pos != 0) {
				players.remove(winner_pos);
				players.add(winner_pos - 1, winner);
			}
		}			
		else {
			int move = (winner_pos - looser_pos) / 2;
			if (move != 0) {				
				players.remove(winner_pos);
				players.add(winner_pos - move, winner);
			}			
		}
		
		if (looser_pos != players.size() - 1) {
			players.remove(looser_pos);
			players.add(looser_pos + 1, looser);
		}
	}
	
	public int count() {
		return players.size();
	}
	
	public Iterable<String> standings() {
		return Collections.unmodifiableList(players);		
	}		
}
