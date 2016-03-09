package ants;

import core.Bee;
import core.AntColony;
import core.Place;
import core.Ant;
import core.Containing;

public class QueenAnt extends ScubaThrowerAnt {
		
	protected int buff;
	
	public QueenAnt() {
		super();
		this.foodCost = 6;
		buff = 2;
	}
	
	public void action (AntColony colony) {
		//initialisation des variables utiles
		Bee target = getTarget();
		if (target != null) {
			target.reduceArmor(damage);
		}
		
		if (this.getPlace() != null) {
			Place queenPlace = this.getPlace();
			Place afterqueen = null;
			Place beforequeen = null;
			if (queenPlace.getExit() != null) {
				beforequeen = queenPlace.getExit();
				if (beforequeen.getAnt() != null) {
					Ant ant = beforequeen.getAnt();
					if (ant instanceof Containing) {
						Containing cont_ant = (Containing) ant;
						if(!(cont_ant.getInsectIn().getBuffed())) {
							cont_ant.getInsectIn().setDamage(cont_ant.getInsectIn().getDamage() + buff);
							System.out.println(cont_ant.getInsectIn() + "has been buffed"); // information
							cont_ant.getInsectIn().setbuffed(true);
						}
					}
					else {
						if(!(ant.getBuffed())) {
							ant.setDamage(ant.getDamage() + buff);
							System.out.println(ant + "has been buffed"); // information
							ant.setbuffed(true);
						}
					}
				}
				else {
					System.out.println("There is no ant to buff on the place before queen :  " + beforequeen); //information
				}
			}
			else {
				System.out.println("No place beforequeen" + queenPlace); // information
			}
			if (queenPlace.getEntrance() != null) {
				afterqueen = queenPlace.getEntrance();
				if (afterqueen.getAnt() != null) {
					Ant ant = beforequeen.getAnt();
					if (ant instanceof Containing) {
						Containing cont_ant = (Containing) ant;
						if(!(cont_ant.getInsectIn().getBuffed())) {
							cont_ant.getInsectIn().setDamage(cont_ant.getInsectIn().getDamage() + buff);
							System.out.println(cont_ant.getInsectIn() + "has been buffed"); // information
							cont_ant.getInsectIn().setbuffed(true);
						}
					}
					else {
						if(!(ant.getBuffed())) {
							ant.setDamage(ant.getDamage() + buff);
							System.out.println(ant + "has been buffed"); // information
							ant.setbuffed(true);
						}
					}
				}
				else {
					System.out.println("There is no ant to buff on the place after queen :  " + afterqueen); //information
				}
			}
			else {
				System.out.println("No place afterqueen :  " + queenPlace); //information
			}
		}
		
	}
	
}
