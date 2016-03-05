package ants;

import core.Ant;
import core.AntColony;

/**
 * The first new ant arrive in the colony !	
 * @author Max
 *
 */

public class WallAnt extends Ant {
	
	/**
	 * Creates a new Wall Ant.
	 * Armor : 4, food : 4, damage : 0.
	 */

	public WallAnt () {
		super(4,4);
	}
	
	/**
	 * Do nothing.
	 */
	public void action (AntColony colony) {
	}
}
