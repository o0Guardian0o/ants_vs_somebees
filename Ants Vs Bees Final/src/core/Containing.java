package core;

	/**Interface for ants containers
	 * @author Max
	 */

public interface Containing {
		
	/**
	 * Add an insect in the containing (create the link between the ant and its bodyguard !)
	 * @param ant which must be contained
	 * @return a boolean which indicate if the insect can be added !
	 */
	public boolean addInsectIn(Ant ant) ;
	
	/**
	 * Remove the link between the ant containing and the ant contained
	 * @param ant which must be removed
	 * @return a boolean which indicate if the insect can be removed
	 */
	public boolean removeInsectIn(Ant ant) ;
	/**
	 * getter of the insect in the containing
	 * @return the ant contained or null if there is no ant contained
	 */
	public Ant getInsectIn();
	
}