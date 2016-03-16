package ants;

import core.Ant;
import core.AntColony;
import core.Bee;

public class NinjaAnt extends Ant {
	
	public NinjaAnt() {
		super(1,6);
		this.viewable = false;
		this.damage = 1;
	}
	
	public void action (AntColony colony) {
		Bee[] bees = place.getBees();
		if (bees != null) {
			for (int i=0; i<= bees.length-1; i++ ) {
				if (this.damage < bees[i].getArmor()) {
					System.out.println("Ninja ant Report : \n " + this + "has hurt " + bees[i] + " by : " + this.damage);
					bees[i].reduceArmor(damage);
				}
				else {
					System.out.println("Ninja ant Report : \n " + this + "has hurt " + bees[i] + " by : " + this.damage);
					if (colony.getLvSystem()) {
						this.expUp(bees[i].getArmorInit());
					}
					bees[i].reduceArmor(damage);

				}
			}
		}
	}

}
