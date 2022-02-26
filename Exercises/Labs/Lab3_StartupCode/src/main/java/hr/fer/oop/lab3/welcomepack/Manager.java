package hr.fer.oop.lab3.welcomepack;

/**
 * A manager knows how to manage a team by implementing this interface.
 * 
 * @author OOP
 *
 */
public interface Manager {

	/**
	 * A method used to pick the starting eleven from a team he manages (NOTE: only the players
	 * from registered players collection are eligible);
	 * a method must be careful to pick such players who can form a team formation
	 * (e.g., a number of forwards within first eleven should match a number of forwards in a team formation).
	 */
	public void pickStartingEleven();

	/**
	 * A manager uses his formation to set team's formation.
	 */
	public void forceMyFormation();

	/**
	 * 
	 * With this method, a manager sets a team he manages if a team is not null.
	 * 
	 * @param team
	 *            team
	 */
	public void setManagingTeam(ManageableTeam team);

}
