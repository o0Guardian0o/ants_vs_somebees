package ants;


import core.Bee;
import core.AntColony;
import core.Place;
import core.Ant;
import core.Containing;
import core.QueenPlace;
import core.Unkillable;

public class QueenAnt extends ScubaThrowerAnt implements Unkillable {
		
	protected int buff;
	protected QueenPlace qp;
	protected static int nb_queen = -1;
	protected int numero_queen;
	
	public QueenAnt() {
		super();
		this.foodCost = 6;
		buff = 2;
		incrementNombreQueen();
		setNumQueen();
	}
	
	public void setQueenPlace(AntColony colony) {
		QueenPlace queen_place = colony.getQueenPlace();
		qp = queen_place;
	}
	
	public QueenPlace getQueenPlace() {
		return this.qp;
	}
	
	public void setNombreQueen(int nb) {
		this.nb_queen = nb;
	}
	
	public void incrementNombreQueen() {
		this.nb_queen ++;
	}
	
	public int getNombreQueen() {
		return this.nb_queen;
	}
	
	public void setNumQueen() {
		this.numero_queen = nb_queen;
	}
	
	public int getNumQueen() {
		return this.numero_queen;
	}
	
	public void killFalseQueen() {
		this.setNombreQueen(this.nb_queen -1);
		this.place.removeInsect(this);
		
	}
	
	public void action (AntColony colony) {
		if (getNumQueen() == 1) {
			// mise à jour de la variable queenplace
			this.setQueenPlace(colony);
			colony.getQueenPlace().setQueenPos(this.place);
			
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
						Ant ant = afterqueen.getAnt();
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
		else {
			this.killFalseQueen();
			System.out.println("The false queen has been killed !!!" + this.numero_queen); //information
		}
	}
}
