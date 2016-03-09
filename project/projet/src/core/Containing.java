package core;

	/**Interface for ants containers
	 * @author Max
	 */

public interface Containing {
		
	public boolean addInsectIn(Ant ant) ;
	
	public boolean removeInsectIn(Ant ant) ;
	
	public Ant getInsectIn();
	
}