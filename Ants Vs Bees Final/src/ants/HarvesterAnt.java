package ants;

import core.Ant;
import core.AntColony;

/**
 * An Ant that harvests food
 *
 * @author YOUR NAME HERE
 */
public class HarvesterAnt extends Ant {

	private int food_produced;
	/**
	 * Creates a new Harvester Ant
	 * Armor : 1, food : 2, damage : 0
	 */
	public HarvesterAnt () {
		super(1,2);
		food_produced = 1;
	}

	/**
	 * Set the action of the ant
	 * 
	 * @param colony
	 *            Colony with this instance
	 */
	@Override
	public void action (AntColony colony) {
		colony.increaseFood(food_produced);
		System.out.println("Harvester Ant Report : \n " + this + " have produced " + this.food_produced + " food");
		if (colony.getLvSystem()) {
			this.expUp(1);
		}
	}
	
	public void levelUp() {
		this.lv ++;
		this.food_produced += this.lv;
		this.armor = this.armor_init + lv -1;
		System.out.println("Ant report : \n " + this + "has level up !"
				+ "\n He will produce " + this.food_produced + " foods by turn !"
						+ "\n He has " + this.armor + " armor !");
	}
}
