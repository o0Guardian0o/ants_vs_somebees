package core;

import java.util.ArrayList;

public class QueenPlace extends Place {
	
	private Place queen_pos; // the current place of the QueenAnt
	
	/**
	 * Constructor of the instance of a QueenPlace
	 * 
	 * @param name The name of the QueenPlace
	 * @param exit The exit of the QueenPlace
	 */
	public QueenPlace(String name, Place exit) {
		super(name,exit);
		queen_pos = null;
	}
	/**
	 * Overload (the same as it is done in the class Place)
	 * 
	 * @param name The name of the QueenPlace
	 */
	public QueenPlace (String name) {
		this(name, null);
	}

	public void setQueenPos(Place p) {
		this.queen_pos = p;
	}

	/**
	 * Returns a list of the bees in the queen places
	 * 
	 * @return Bee[] a list of the bees in the queen places
	 */
	public Bee[] getBees() {
		ArrayList<Bee> bees_on_the_two_place = new ArrayList<Bee>();
		bees_on_the_two_place.addAll(this.getBebees());
		if (queen_pos != null) {
			bees_on_the_two_place.addAll(queen_pos.getBebees());
		}
		return bees_on_the_two_place.toArray(new Bee[0]);
	}

}
