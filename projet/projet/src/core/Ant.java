package core;

/**
 * A class representing a basic Ant
 *
 * @author YOUR NAME HERE
 */
public abstract class Ant extends Insect {

	protected int foodCost; // the amount of food needed to make this ant
	protected boolean viewable;
	
	/**
	 * Creates a new Ant, with a food cost of 0.
	 *
	 * @param armor
	 *            The armor of the ant.
	 */
	public Ant (int armor) {
		super(armor, null);
		foodCost = 0;
		viewable = true;
	}
	/**
	 * Creates a new Ant, with a food cost of foodneeded.
	 * @param armor
	 * 		The armor of the ant.
	 * @param foodneeded
	 * 		The food we need to place this ant.
	 */
	public Ant (int armor, int foodneeded) {
		super(armor, null);
		foodCost = foodneeded;
		viewable = true;
	}

	/**
	 * Returns the ant's food cost
	 *
	 * @return the ant's good cost
	 */
	public int getFoodCost () {
		return foodCost;
	}
	
	public boolean getViewable () {
		return this.viewable;
	}
	/**
	 * Removes the ant from its current place
	 */
	@Override
	public void leavePlace () {
		place.removeInsect(this);
	}
}
