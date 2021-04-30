package hr.fer.oop.homework_09.t03;

import java.util.*;

import hr.fer.oop.homework_09.t01.Ladder;

public class LadderEnhanced extends Ladder {
	private Map<String, PlayerInfo> statistics = new HashMap<>();
	public LadderEnhanced(String...players) {
		super(players);
	}
	
	@Override
	public void gameFinished(String winner, String looser) {
		PlayerInfo info = statistics.get(winner);
		if (info == null) {
			info = new PlayerInfo();
			statistics.put(winner, info);
		}
		info.setWins(info.getWins() + 1);
		
		info = statistics.get(looser);
		if (info == null) {
			info = new PlayerInfo();
			statistics.put(looser, info);
		}
		info.setLosses(info.getLosses() + 1);
		
		super.gameFinished(winner, looser);
	}
	
	public int wins(String player) {
		PlayerInfo info = statistics.get(player);
		return info != null ? info.getWins() : 0;
	}
	public int losses(String player) {
		PlayerInfo info = statistics.get(player);
		return info != null ? info.getLosses() : 0;
	}		
}
