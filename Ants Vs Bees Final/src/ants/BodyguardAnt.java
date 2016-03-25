package ants;

import core.Ant;
import core.AntColony;
import core.Containing;

public class BodyguardAnt extends Ant implements Containing {

	private Ant contained_ant;

	/**
	 * Creates a new BodyGuard
	 */
	public BodyguardAnt() {
		super(2, 5);
		contained_ant = null;
		this.containable = false;
		this.watersafe = true;
	}

	/**
	 * Function to add insect on containing
	 * 
	 * @return if you can add an insect in containing
	 */
	public boolean addInsectIn(Ant ant) {
		if (ant.getContainable() == true) {
			contained_ant = ant;
			return true;
		} else {
			return false;
		}

	}

	/**
	 * Function to remove an insect from containing
	 * 
	 * @return if you can remove an insect from containing
	 */
	public boolean removeInsectIn(Ant ant) {
		if (ant.getContainable() == true) {
			contained_ant = null;
			return true;
		} else {
			return false;
		}

	}

	/**
	 * Return the insect in containing
	 * 
	 * @return the insect in containing
	 */
	public Ant getInsectIn() {
		return contained_ant;
	}

	/**
	 * Set the action of the ant
	 * 
	 * @param colony
	 *            Colony with this instance
	 */
	public void action(AntColony colony) {
		if (colony.getLvSystem()) {
			this.expUp(1);
		}
	}

	@Override
	public void levelUp() {
		this.lv++;
		this.armor = this.armor_init + (int) Math.ceil(Math.exp(this.lv));
		System.out.println("Ant report : \n " + this + "has level up !" + "\n He now has " + this.armor + " armor !");
	}
}
