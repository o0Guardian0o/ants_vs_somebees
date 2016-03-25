package ants;

import core.AntColony;
import core.Bee;

public class AntMage extends ThrowerAnt {

	private int count = 0;

	public AntMage() {
		super();
		this.foodCost = 5;
		this.armor = 1;
		this.damage = 10;
	}

	public Bee getTarget() {
		return place.getClosestBee(0, this.range);
	}

	@Override
	public void action(AntColony colony) {
		if (count == 0) {
			Bee target = getTarget();
			if (target != null) {
				if (this.damage < target.getArmor()) {
					System.out.println("Thrower ant Report : \n " + this + "has hurt " + this.getTarget() + " by : "
							+ this.damage);
					target.reduceArmor(damage);
				} else {
					System.out.println("Thrower ant Report : \n " + this + "has hurt " + this.getTarget() + " by : "
							+ this.damage);
					if (colony.getLvSystem()) {
						this.expUp(target.getArmorInit());
					}
					target.reduceArmor(damage);
				}
			}
			count++;
		} else {
			count = 0;
		}
	}

}
