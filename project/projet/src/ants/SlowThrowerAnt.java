package ants;

import core.AntColony;

public class SlowThrowerAnt extends ThrowerAnt {
	
	public SlowThrowerAnt() {
		super();
	}
	
	public void slow() {
		if (super.getTarget() != null) {
			super.getTarget().setSlowed(true);
			super.getTarget().setTurnSlow(2);
			super.getTarget().setCounter(3);
		}
	}
	
	public void action(AntColony colony) {
		super.action(colony);
		this.slow();
	}

}
