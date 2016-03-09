package ants;

import core.Ant;
import core.AntColony;
import core.Bee;

public class NinjaAnt extends Ant {
	
	public NinjaAnt() {
		super(1,6);
		this.viewable = false;
		this.damage = 10;
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
