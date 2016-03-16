package ants;

import core.Ant;
import core.AntColony;
import core.Bee;

/**
 * An ant who throws leaves at bees
 *
 * @author Max
 */
public class ThrowerAnt extends Ant {

	protected int range;

	/**
	 * Creates a new Thrower Ant.
	 * Armor: 1, Food: 4, Damage: 1
	 */
	public ThrowerAnt () {
		super(1,4);
		damage = 1;
		range = 3;
	}

	/**
	 * Returns a target for this ant
	 *
	 * @return A bee to target
	 */
	public Bee getTarget () {
		return place.getClosestBee(0, this.range);
	}

	@Override
	public void action (AntColony colony) {
		Bee target = getTarget();
		if (target != null) {
			if ( this.damage < target.getArmor()) {
				System.out.println("Thrower ant Report : \n " + this + "has hurt " + this.getTarget() + " by : " + this.damage);
				target.reduceArmor(damage);
			}
			else {
				System.out.println("Thrower ant Report : \n " + this + "has hurt " + this.getTarget() + " by : " + this.damage);
				if (colony.getLvSystem()) {
					this.expUp(target.getArmorInit());
				}
				target.reduceArmor(damage);
			}
		}
	}
}
