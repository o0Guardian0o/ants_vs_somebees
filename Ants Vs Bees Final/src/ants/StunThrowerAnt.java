package ants;

import core.AntColony;

public class StunThrowerAnt extends ThrowerAnt {

	/**
	 * Creates a new StunThrowerAnt
	 */
	public StunThrowerAnt() {
		super();
		this.foodCost = 6;
	}

	/**
	 * Function to stun the targeted bee
	 */
	public void stun() {
		if (super.getTarget() != null) {
			super.getTarget().setStuned(true);
		}
	}

	/**
	 * Set the action of the ant
	 * 
	 * @param colony
	 *            Colony with this instance
	 */
	public void action(AntColony colony) {
		super.action(colony);
		this.stun();
	}

}
