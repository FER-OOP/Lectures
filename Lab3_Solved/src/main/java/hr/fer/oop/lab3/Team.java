package hr.fer.oop.lab3;

import hr.fer.oop.lab3.welcomepack.Constants;
import hr.fer.oop.lab3.welcomepack.Formation;
import hr.fer.oop.lab3.welcomepack.ManageableTeam;
import hr.fer.oop.lab3.welcomepack.SimpleFootballPlayerCollection;

/**
 * TODO: Document this class...
 */
public abstract class Team implements ManageableTeam {

    private final String name;
    private Formation formation;
    private final SimpleFootballPlayerCollection registeredPlayers;
    private final SimpleFootballPlayerCollection startingEleven = new SimpleFootballPlayerCollectionImpl(Constants.STARTING_ELEVEN_SIZE);

    public Team(String name, Formation formation, int registeredPlayersSize) {
    	this.name = name;
    	this.formation = formation;    
        this.registeredPlayers = new SimpleFootballPlayerCollectionImpl(registeredPlayersSize);
    }

    public Team(String name, int registeredPlayersSize){
        this(name, Constants.DEFAULT_FORMATION, registeredPlayersSize);
    }

    @Override
    public boolean addPlayerToStartingEleven(FootballPlayer player) {
        if(registeredPlayers.contains(player) && !startingEleven.contains(player) && startingEleven.size() < Constants.STARTING_ELEVEN_SIZE){
            startingEleven.add(player);
            return true;
        }
        return false;
    }

    @Override
    public void clearStartingEleven() {
        startingEleven.clear();
    }

    @Override
    public Formation getFormation() {
        return formation;
    }

    @Override
    public SimpleFootballPlayerCollection getRegisteredPlayers() {
        return registeredPlayers;
    }

    @Override
    public SimpleFootballPlayerCollection getStartingEleven() {
        return startingEleven;
    }

    @Override
    public boolean isPlayerRegistered(FootballPlayer player) {
        return registeredPlayers.contains(player);
    }

    @Override
    public void setFormation(Formation formation) {
        if(formation!=null)
            this.formation = formation;
        else System.err.println("Formacija je null! :(");
    }
}
