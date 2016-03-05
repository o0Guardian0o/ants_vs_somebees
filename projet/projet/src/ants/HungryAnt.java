package ants;

import core.Ant;
import core.Bee;
import core.AntColony;

public class HungryAnt extends Ant {
	
	protected int time;
	
	public HungryAnt () {
		super(1,4);
	}

	public Bee getTarget () {
		return place.getClosestBee(0, 0);
	}
	
	public void action (AntColony colony) {
		Bee Target = getTarget();
		if (time==0 && Target != null) {
			Target.reduceArmor(Target.getArmor());
			time = 3;
		}
		else {
			if (time != 0) {
				time = time - 1;
			}
		}
	}
}
