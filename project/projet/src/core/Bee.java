
package core;

/**
 * Represents a Bee
 *
 * @author YOUR NAME HERE
 */
public class Bee extends Insect {

	private boolean slowed;
	private int turn_slow;
	private int counter;
	private boolean stuned;
	private int armor_init;
	
	private static final int DAMAGE = 1;

	/**
	 * Creates a new bee with the given armor
	 *
	 * @param armor
	 *            The bee's armor
	 */
	public Bee (int armor) {
		super(armor);
		this.watersafe = true;
		this.slowed = false;
		this.stuned = false;
		this.armor_init = armor;
	}

	/**
	 * Deals damage to the given ant
	 *
	 * @param ant
	 *            The ant to sting
	 */
	public void sting (Ant ant) {
		ant.reduceArmor(DAMAGE);
	}

	/**
	 * Moves to the given place
	 *
	 * @param place
	 *            The place to move to
	 */
	public void moveTo (Place place) {
		this.place.removeInsect(this,0);
		place.addInsect(this);
	}

	@Override
	public void leavePlace () {
		place.removeInsect(this);
		/*
		if (this.place.getAnt() != null) {
			if(this.place.getAnt() instanceof Containing) {
				Containing cont_ant = (Containing) this.place.getAnt();
				((Ant) cont_ant).expUp(armor_init);
				cont_ant.getInsectIn().expUp(armor_init);
			}
			else {
				this.place.getAnt().expUp(armor_init);
			}
		}*/
	}

	/**
	 * Returns true if the bee cannot advance (because an ant is in the way)
	 *
	 * @return if the bee can advance
	 */
	public boolean isBlocked () {
		return place.getAnt() != null && place.getAnt().getViewable() == true; 
	}

	/**
	 * A bee's action is to sting the Ant that blocks its exit if it is blocked,
	 * otherwise it moves to the exit of its current place.
	 */
	@Override
	public void action (AntColony colony) {
		if (!(this.slowed) && !(this.stuned)) {
			if (isBlocked()) {
				sting(place.getAnt());
			}
			else if (armor > 0) {
				moveTo(place.getExit());
			}
		}
		else if (this.slowed) {
			this.actionSlowed(colony);
		}
		else if (this.stuned) {
			this.actionStuned(colony);
		}
	}
	
	
	public void actionSlowed(AntColony colony) {
		if (turn_slow == 0) {
			if (isBlocked()) {
				sting(place.getAnt());
				this.counter -=1;
				this.turn_slow = 2;
			}
			else if (armor > 0) {
				moveTo(place.getExit());
				this.counter -= 1;
				this.turn_slow = 2;
			}
		}
		else if (counter == 0) {
			this.setSlowed(false);
		}
		else {
			this.turn_slow -= 1;
		}
	}
	
	public void actionStuned(AntColony colony) {
		this.stuned = false;
	}
	
	public boolean getSlowed () {
		return this.slowed;
	}
	
	public void setSlowed(boolean bool) {
		this.slowed = bool;
	}
	
	public int getTurnSlow() {
		return this.turn_slow;
	}
	
	public int getCounter() {
		return this.counter;
	}
	
	public void setTurnSlow(int i) {
		this.turn_slow = i;
	}
	
	public void setCounter(int i) {
		this.counter = i;
	}
	
	public void setStuned(boolean bool) {
		this.stuned = bool;
	}
	
	public boolean getStuned () {
		return this.stuned;
	}
	
	public int getArmor() {
		return this.armor;
	}
	
	public int getArmorInit() {
		return this.armor_init;
	}
}
