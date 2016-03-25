package ants;

import java.math.*;
import core.Ant;
import core.AntColony;

/**
 * The first new ant arrive in the colony !	
 * @author Max
 *
 */

public class WallAnt extends Ant {
	
	/**
	 * Creates a new Wall Ant.
	 * Armor : 4, food : 4, damage : 0.
	 */

	public WallAnt () {
		super(4,4);
	}
	
	/**
	 * Do nothing.
	 */
	public void action (AntColony colony) {
		if (colony.getLvSystem()) {
			this.expUp(1);
		}
	}
	
	public void levelUp() {
		this.lv ++;
		this.armor = this.armor_init + (int) Math.ceil(Math.exp(this.lv));
		System.out.println("Ant report : \n " + this + "has level up !" +
		"\n He now has " + this.armor + " armor !");
	}
	
	
}
