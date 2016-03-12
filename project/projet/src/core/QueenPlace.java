package core;

import java.util.ArrayList;

public class QueenPlace extends Place {
	
	private Place queen_pos;
	
	public QueenPlace(String name, Place exit) {
		super(name,exit);
		queen_pos = null;
	}
	
	public QueenPlace (String name) {
		this(name, null);
	}
	
	public void setQueenPos(Place p) {
		this.queen_pos = p;
	}
	
	public Bee[] getBees() {
		ArrayList<Bee> bees_on_the_two_place = new ArrayList<Bee>();
		bees_on_the_two_place.addAll(this.getBebees());
		if (queen_pos != null) {
			bees_on_the_two_place.addAll(queen_pos.getBebees());
		}
		return bees_on_the_two_place.toArray(new Bee[0]);
	}

}
