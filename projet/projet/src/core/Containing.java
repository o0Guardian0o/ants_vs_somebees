package core;

	/**Interface for ants containers
	 * @author Max
	 */

public interface Containing {
		
	public void addInsectIn(Ant ant) ;
	
	public void removeInsectIn(Ant ant) ;
	
	public Ant getInsectIn();
	
}