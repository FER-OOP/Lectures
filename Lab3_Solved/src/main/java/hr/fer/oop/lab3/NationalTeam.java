package hr.fer.oop.lab3;

import hr.fer.oop.lab3.welcomepack.Constants;
import hr.fer.oop.lab3.welcomepack.Formation;

/**
 * TODO: Document this class
 */
public class NationalTeam extends Team {

    private String country = Constants.DEFAULT_COUNTRY;

    public NationalTeam(String country){    	
        super(country, Constants.MAX_NO_PLAYERS_NATIONAL);
        this.country = country;
    }  
    
    public NationalTeam(String country, Formation formation){    	
        super(country, formation, Constants.MAX_NO_PLAYERS_NATIONAL);
        this.country = country;
    } 
 
    @Override
    public boolean registerPlayer(FootballPlayer player) {
    	if (player != null && player.getCountry().equals(country)) {
    		return getRegisteredPlayers().add(player);
    	}
    	else {
    		return false;
    	}    	
    }

    @Override
    public double calculateRating() {
        return Constants.SEVENTY_PERCENT * getRegisteredPlayers().calculateEmotionSum() + Constants.THIRTY_PERCENT * getRegisteredPlayers().calculateSkillSum();
    }
}
