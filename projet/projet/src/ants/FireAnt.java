package ants;

import core.Ant;
import core.AntColony;
import core.Bee;

public class FireAnt extends Ant {
	protected int damage;
	
	public FireAnt () {
		super(1,4);
		damage = 10;
	}

	public void reduceArmor (int amount) {
		armor -= amount;
		if (armor <= 0) {
			Bee[] bees = place.getBees();
			for (int i=0; i<= bees.length-1; i++ ) {
				bees[i].reduceArmor(damage);
			}
			System.out.println(this + " ran out of armor and expired");
			leavePlace();
		}
	}
	
	public void action (AntColony colony) {
	}
}
