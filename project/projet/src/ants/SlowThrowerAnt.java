package ants;

import core.AntColony;

public class SlowThrowerAnt extends ThrowerAnt {
	
	public SlowThrowerAnt() {
		super();
	}
	
	public void slow() {
		this.getTarget().setSlowed(true);
		this.getTarget().setTurnSlow(2);
		this.getTarget().setCounter(3);
	}
	
	public void action(AntColony colony) {
		super.action(colony);
		this.slow();
	}

}
