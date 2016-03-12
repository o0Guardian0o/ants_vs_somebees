package ants;

import core.AntColony;

public class StunThrowerAnt extends ThrowerAnt { 
	
	public StunThrowerAnt() {
		super();
		this.foodCost = 6;
	}
	
	public void stun() {
		if (super.getTarget() != null) {
			super.getTarget().setStuned(true);
		}
	}
	
	public void action(AntColony colony) {
		super.action(colony);
		this.stun();
	}

}
