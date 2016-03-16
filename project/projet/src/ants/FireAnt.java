package ants;

import core.Ant;
import core.AntColony;
import core.Bee;

public class FireAnt extends Ant {
	
	public FireAnt () {
		super(1,4);
		this.damage = 4;
	}

	
	public void reduceArmor (int amount) {
		armor -= amount;
		if (armor <= 0) {
			Bee[] bees = place.getBees();
			System.out.println("Fire Ant Report : \n " + this + " has dammaged " + bees + " by diying");
			for (int i=0; i<= bees.length-1; i++ ) {
				bees[i].reduceArmor(damage);
			}
			System.out.println(this + " ran out of armor and expired");
			leavePlace();
		}
	}
	
	public void action (AntColony colony) {
		if (colony.getLvSystem()) {
			this.expUp(1);
		}
	}
}
