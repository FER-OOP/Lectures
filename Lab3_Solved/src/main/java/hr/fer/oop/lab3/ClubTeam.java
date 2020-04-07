package hr.fer.oop.lab3;

import hr.fer.oop.lab3.welcomepack.Constants;
import hr.fer.oop.lab3.welcomepack.Formation;

/**
 * TODO: Document this class
 */
public class ClubTeam extends Team {
    private int reputation = Constants.DEFAULT_REPUTATION;

    public ClubTeam(String name) {
    	super(name, Constants.MAX_NO_PLAYERS_CLUB);
    }
    
    public ClubTeam(String name, int reputation) {
    	super(name, Constants.MAX_NO_PLAYERS_CLUB);
    	setReputation(reputation);
    }
    
    public ClubTeam(String name, Formation formation, int reputation) {
        super(name, formation, Constants.MAX_NO_PLAYERS_CLUB);
        setReputation(reputation);
    }

    
    public void setReputation(int reputation) {
        if (reputation >= Constants.MIN_REPUTATION && reputation <= Constants.MAX_REPUTATION)
            this.reputation = reputation;
        else System.err.println("Reputation out of range! :(");
    }

    public int getReputation() {
        return reputation;
    }

    @Override
    public boolean registerPlayer(FootballPlayer player) {
        if (player != null && player.getPlayingSkill() >= reputation) {
        	return getRegisteredPlayers().add(player);
        }
        else {
        	return false;
        }
    }

    @Override
    public double calculateRating() {
        return Constants.THIRTY_PERCENT * getRegisteredPlayers().calculateEmotionSum() + Constants.SEVENTY_PERCENT * getRegisteredPlayers().calculateSkillSum();
    }
}
