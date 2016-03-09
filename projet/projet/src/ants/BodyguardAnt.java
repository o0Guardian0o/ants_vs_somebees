package ants;

import core.Ant;
import core.AntColony;
import core.Containing;

public class BodyguardAnt extends Ant implements Containing {
	
	private Ant contained_ant;
	
	public BodyguardAnt() {
		super(2,5);
		contained_ant = null;
	}
	
	public void addInsectIn(Ant ant) {
		contained_ant = ant;
	}
	
	public void removeInsectIn(Ant ant) {
		contained_ant = null;
	}
	
	public Ant getInsectIn() {
		return contained_ant;
	}
	
	public void action(AntColony colony) {
		
	}
}
