package core;

/**
 * A class representing a basic Ant
 *
 * @author YOUR NAME HERE
 */
public abstract class Ant extends Insect {

	protected int foodCost; // the amount of food needed to make this ant
	protected boolean viewable;
	protected boolean containable;
	protected boolean buffed;
	protected int damage;
	protected int lv;
	protected int exp;
	protected int exp_seuil;
	protected int armor_init;
	
	/**
	 * Creates a new Ant, with a food cost of 0.
	 *
	 * @param armor
	 *            The armor of the ant.
	 */
	public Ant (int armor) {
		super(armor, null);
		armor_init = armor;
		foodCost = 0;
		viewable = true;
		containable = true;
		buffed = false;
		damage = 0;
		lv = 1;
		exp = 0;
		exp_seuil = 3*this.lv;
	}
	/**
	 * Creates a new Ant, with a specific food cost.
	 * @param armor
	 * 		The armor of the ant.
	 * @param foodneeded
	 * 		The food we need to place this ant.
	 */
	public Ant (int armor, int foodneeded) {
		super(armor, null);
		armor_init = armor;
		foodCost = foodneeded;
		viewable = true;
		containable = true;
		buffed = false;
		damage = 0;
		lv = 1;
		exp = 0;
		exp_seuil = 3*this.lv;
	}

	public void levelUp() {
		this.lv ++;
		this.damage += this.lv;
		this.armor = this.armor_init + lv -1;
		System.out.println("Ant report : \n " + this + "has level up !"
				+ "\n He has " + this.damage + " damgage, " +
				"\n " + this.armor + " armor !");
	}
	
	public void expUp(int i) {
		if (this.exp + i >= exp_seuil) {
			this.levelUp();
			this.exp = exp_seuil - this.exp;
			this.exp_seuil = 3*this.lv;
		}
		else {
			this.exp += i;
			System.out.println("Ant report : \n " + this + "has gained exp !"
					+ "\n Still " + this.exptoearn() + " to earn !");
		}
	}
	
	public int exptoearn() {
		return this.exp_seuil - this.exp;
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
	
	public boolean getContainable() {
		return this.containable;
	}
	
	public void setbuffed(boolean b) {
		this.buffed = b;
	}
	
	public boolean getBuffed() {
		return this.buffed;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}
	
	public int getDamage() {
		return this.damage;
	}
	
	public int getLv() {
		return this.lv;
	}
	
	public void setLv(int lv) {
		this.lv = lv;
	}
	
	public int getExp() {
		return this.exp;
	}
	
	public int getExpSeuil() {
		return this.exp_seuil;
	}
	
	/** 
	 * Removes the ant from its current place
	 */
	@Override
	public void leavePlace () {
		if (!(this instanceof Unkillable)) {
			place.removeInsect(this);
		}
		else {
			System.out.println("Ant report : " + this + "Can't be kill"); //information
		}
	}
}
