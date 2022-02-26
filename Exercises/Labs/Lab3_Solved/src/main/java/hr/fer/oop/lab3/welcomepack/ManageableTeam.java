package hr.fer.oop.lab3.welcomepack;

import hr.fer.oop.lab3.FootballPlayer;

/**
 * A team can be managed according to this interface.
 * 
 * @author OOP
 *
 */
public interface ManageableTeam {

	/**
	 * 
	 * Adds a player to starting eleven if a player is in registered player
	 * collection and there is a space for him within starting eleven.
	 * registriranih igraca te ima mjesta u prvih 11.
	 * 
	 * @param player
	 *            player
	 * @return true if a player is added, false otherwise.
	 */
	public boolean addPlayerToStartingEleven(FootballPlayer player);

	/**
	 * Checks whether a player is registered in a team.
	 * 
	 * @param player
	 *            player
	 * @return true if a player is registered, false otherwise.
	 */
	public boolean isPlayerRegistered(FootballPlayer player);

	/**
	 * Returns a collection of registered players.
	 * 
	 * @return registered players.
	 */
	public SimpleFootballPlayerCollection getRegisteredPlayers();

	/**
	 * Returns a collection of starting eleven.
	 * 
	 * @return starting eleven.
	 */
	public SimpleFootballPlayerCollection getStartingEleven();

	/**
	 * If a team is a national team, a player need to have the same country as a national
	 * team; whereas if a team is a club team, a player needs to have player
	 * skill which is higher or equal to club's reputation (note: in either case
	 * player registration will be successful if there is a space for a player)
	 * 
	 * @param player
	 *            player
	 * @return true if a player is added, false otherwise.
	 */
	public boolean registerPlayer(FootballPlayer player);

	/**
	 * Sets the formation if it is not null.
	 * 
	 * @param formation
	 *            formation
	 */
	public void setFormation(Formation formation);

	/**
	 * Formation getter.
	 * 
	 * @return formacija formation
	 */
	public Formation getFormation();

	/**
	 * Clears a collection of starting eleven.
	 */
	public void clearStartingEleven();

	/**
	 * Calculates and returns calculated team rating as follows:
	 * 
	 * Club team: 70% sum of skills from registered players + 30% sum of emotions from registered players;
	 * 
	 * 
	 * National team: 30% sum of skills from registered players + 70% sum of emotions from registered players.
	 * 
	 * @return returns a team rating.
	 */
	public double calculateRating();
}
