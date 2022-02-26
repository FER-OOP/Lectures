package hr.fer.oop.lab3.welcomepack;

import hr.fer.oop.lab3.FootballPlayer;

/**
 * 
 * A specification of a simple data structure in which players are stored.
 * Implementation of this interface has (along with variables you find necessary
 * - e.g., int size) an array.
 * 
 * @author OOP
 *
 */
public interface SimpleFootballPlayerCollection {

	/**
	 * 
	 * Returns the number of players currently stored in a collection.
	 * 
	 * @return current number of players within a collection.
	 */
	public int size();

	/**
	 * Checks whether a collection contains a player.
	 * 
	 * @param player
	 *            player
	 * @return true if a collection contains a player, false otherwise.
	 */
	public boolean contains(FootballPlayer player);

	/**
	 * Adds a player in a collection if he has not been previously added and if
	 * there is a space available for a player within a collection.
	 * 
	 * @param player
	 *            player
	 * @return true if a player is added, false otherwise.
	 */
	public boolean add(FootballPlayer player);

	/**
	 * Clears all players from a collection.
	 */
	public void clear();

	/**
	 * Maximum number of players who can be stored in a collection, e.g., if a
	 * collection is used to store starting eleven then this method should
	 * return 11;
	 * 
	 * @return maximum number of players - a collection's capacity.
	 */
	public int getMaxSize();

	/**
	 * Calculates the sum of emotions from all players within a collection.
	 * 
	 * @return the sum of emotions.
	 */
	public int calculateEmotionSum();

	/**
	 * Calculates the sum of skills from all players within a collection.
	 * 
	 * @return the sum of emotions.
	 */
	public int calculateSkillSum();

	/**
	 * Method used to get the underlying array in which players are actually stored.
	 * 
	 * @return an array.
	 */
	public FootballPlayer[] getPlayers();

}
