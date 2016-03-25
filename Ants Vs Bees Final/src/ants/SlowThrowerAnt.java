package ants;

import core.AntColony;

public class SlowThrowerAnt extends ThrowerAnt {

	/**
	 * Creates a new SlowThrowerAnt
	 */
	public SlowThrowerAnt() {
		super();
	}

	/**
	 * Function to slow the targeted bee
	 */
	public void slow() {
		if (super.getTarget() != null) {
			super.getTarget().setSlowed(true);
			super.getTarget().setTurnSlow(2);
			super.getTarget().setCounter(3);
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
		this.slow();
	}

}
