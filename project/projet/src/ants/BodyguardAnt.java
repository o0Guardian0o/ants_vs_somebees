package ants;
import core.Ant;
import core.AntColony;
import core.Containing;

public class BodyguardAnt extends Ant implements Containing {
		
	private Ant contained_ant;
		
	public BodyguardAnt() {
		super(2,5);
		contained_ant = null;
		this.containable = false;
		this.watersafe =true;
	}
		
	public boolean addInsectIn(Ant ant) {
		if (ant.getContainable() == true) {
			contained_ant = ant;
			return true;
		}
		else {
			return false;
		}
		
	}
		
	public boolean removeInsectIn(Ant ant) {
		if (ant.getContainable() == true) {
			contained_ant = null;
			return true;
		}
		else {
			return false;
		}

	}
		
	public Ant getInsectIn() {
		return contained_ant;
	}
		
	public void action(AntColony colony) {
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


