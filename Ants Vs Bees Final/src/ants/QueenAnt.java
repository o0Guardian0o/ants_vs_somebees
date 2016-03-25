package ants;

import core.Ant;
import core.AntColony;
import core.Bee;
import core.Containing;
import core.Place;
import core.QueenPlace;
import core.Unkillable;

public class QueenAnt extends ScubaThrowerAnt implements Unkillable {

	protected int buff;
	protected QueenPlace qp;
	protected static int nb_queen = -1;
	protected int numero_queen;

	/**
	 * Creates a new QueenAnt
	 */
	public QueenAnt() {
		super();
		this.foodCost = 6;
		buff = 2;
		incrementNombreQueen();
		setNumQueen();
	}

	/**
	 * Set the queen place
	 * 
	 * @param colony
	 *            set QueenPlace on this colony
	 */
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
		this.nb_queen++;
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

	/**
	 * Function to remove a false queen
	 */
	public void killFalseQueen() {
		this.setNombreQueen(this.nb_queen - 1);
		this.place.removeInsect(this);

	}

	/**
	 * Set the action of the ant Read System.out.println for more details
	 * 
	 * @param colony
	 *            Colony with this instance
	 */
	public void action(AntColony colony) {
		if (getNumQueen() == 1) {
			// Refresh Queen Place
			this.setQueenPlace(colony);
			colony.getQueenPlace().setQueenPos(this.place);

			// Initialization
			Bee target = getTarget();
			if (target != null) {
				if (this.damage < target.getArmor()) {
					System.out.println("Thrower ant Report : \n " + this + "has hurt " + this.getTarget() + " by : "
							+ this.damage);
					target.reduceArmor(damage);
				} else {
					System.out.println("Thrower ant Report : \n " + this + "has hurt " + this.getTarget() + " by : "
							+ this.damage);
					if (colony.getLvSystem()) {
						this.expUp(target.getArmorInit());
					}
					target.reduceArmor(damage);
				}
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
							if (!(cont_ant.getInsectIn().getBuffed())) {
								cont_ant.getInsectIn().setDamage(cont_ant.getInsectIn().getDamage() + buff);
								System.out.println("Queen report : \n" + cont_ant.getInsectIn() + "has been buffed"); // information
								cont_ant.getInsectIn().setbuffed(true);
							}
						} else {
							if (!(ant.getBuffed())) {
								ant.setDamage(ant.getDamage() + buff);
								System.out.println("Queen report : \n" + ant + "has been buffed"); // information
								ant.setbuffed(true);
							}
						}
					} else {
						System.out.println("Queen report : \n There is no ant to buff on the place before queen :  "
								+ beforequeen); // information
					}
				} else {
					System.out.println("Queen report : \n No place beforequeen" + queenPlace); // information
				}
				if (queenPlace.getEntrance() != null) {
					afterqueen = queenPlace.getEntrance();
					if (afterqueen.getAnt() != null) {
						Ant ant = afterqueen.getAnt();
						if (ant instanceof Containing) {
							Containing cont_ant = (Containing) ant;
							if (!(cont_ant.getInsectIn().getBuffed())) {
								cont_ant.getInsectIn().setDamage(cont_ant.getInsectIn().getDamage() + buff);
								System.out.println("Queen report : \n" + cont_ant.getInsectIn() + "has been buffed"); // information
								cont_ant.getInsectIn().setbuffed(true);
							}
						} else {
							if (!(ant.getBuffed())) {
								ant.setDamage(ant.getDamage() + buff);
								System.out.println("Queen report : \n" + ant + "has been buffed"); // information
								ant.setbuffed(true);
							}
						}
					} else {
						System.out.println(
								"Queen report : \n There is no ant to buff on the place after queen :  " + afterqueen); // information
					}
				} else {
					System.out.println("Queen report : \n No place afterqueen :  " + queenPlace); // information
				}
			}
		} else {
			this.killFalseQueen();
			System.out.println("Queen report : \n The false queen has been killed !!!" + this.numero_queen); // information
		}
	}

	public void levelUp() {
		this.lv++;
		this.damage += this.lv;
		this.armor = this.armor_init + lv - 1;
		this.buff += 1;
		System.out.println("Ant report : \n " + this + "has level up !" + "\n She has " + this.damage + " damage,"
				+ "\n " + this.armor + " armor, " + "\n " + this.buff + "buff points !");
	}
}
