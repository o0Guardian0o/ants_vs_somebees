package ants;

import core.Ant;
import core.AntColony;

/**
 * An Ant that harvests food
 *
 * @author YOUR NAME HERE
 */
public class HarvesterAnt extends Ant {

	/**
	 * Creates a new Harvester Ant
	 * Armor : 1, food : 2, damage : 0
	 */
	public HarvesterAnt () {
		super(1,2);
	}

	@Override
	public void action (AntColony colony) {
		colony.increaseFood(1);
	}
}
