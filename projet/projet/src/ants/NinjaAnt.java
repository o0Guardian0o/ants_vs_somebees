package ants;

import core.Ant;
import core.AntColony;
import core.Bee;

public class NinjaAnt extends Ant {
	
	protected int damage = 10 ;
	
	public NinjaAnt() {
		super(1,6);
		this.viewable = false;
	}
	
	public void action (AntColony colony) {
		Bee[] bees = place.getBees();
		if (bees != null) {
			for (int i=0; i<= bees.length-1; i++ ) {
				bees[i].reduceArmor(damage);
			}
		}
	}

}
