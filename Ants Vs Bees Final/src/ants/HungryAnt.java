package ants;

import core.Ant;
import core.Bee;
import core.AntColony;

public class HungryAnt extends Ant {

	protected int time;
	
	/**
	 *  Creates a new HungryAnt
	 */
	public HungryAnt() {
		super(1, 4);
	}
	
	/**
	 * Catch the closest bee
	 * @return the closest bee
	 */
	public Bee getTarget() {
		return place.getClosestBee(0, 0);
	}

	/**
	 * Set the action of the ant
	 * 
	 * @param colony
	 *            Colony with this instance
	 */
	public void action(AntColony colony) {
		Bee Target = getTarget();
		if (time == 0 && Target != null) {
			System.out.println("Hungry ant Report : \n " + this + "has eaten " + Target);
			if (colony.getLvSystem()) {
				this.expUp(Target.getArmorInit());
			}
			Target.reduceArmor(Target.getArmor());
			time = 3;
		} else {
			if (time != 0) {
				time = time - 1;
			}
		}
	}
}
