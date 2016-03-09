package core;

import java.util.ArrayList;

/**
 * Represents a location in the game
 *
 * @author Joel
 * @version Fall 2014
 */
public class Place {

	private String name; // a name we can use for debugging
	private Place exit; // where you leave this place to
	private Place entrance; // where you enter this place from
	private ArrayList<Bee> bees; // bees currently in the place
	private ArrayList<Ant> ants; // ants currently in the place

	/**
	 * Creates a new place with the given name and exit
	 *
	 * @param name
	 *            The place's name
	 * @param exit
	 *            The place's exit
	 */
	public Place (String name, Place exit) {
		this.name = name;
		this.exit = exit;
		entrance = null;
		bees = new ArrayList<Bee>();
		ants = new ArrayList<Ant>();
	}

	/**
	 * Creates a new place with the given name
	 *
	 * @param name
	 *            The place's name
	 */
	public Place (String name) {
		this(name, null);
	}

	/**
	 * Returns the place's ant
	 *
	 * @return the place's ant
	 */
	public Ant[] getAnt () {
		return ants.toArray(new Ant[0]);
	}
	/**
	 * Returns the ant's container
	 * @return the ant's container
	 */
	public Containing getAntContainer() {
		Containing ant;
		
		for (Ant a : this.getAnt()) {
			if (a instanceof Containing) {
				ant = (Containing) a;
				return ant;
			}
		}
		return null;
	}
	/**
	 * Returns the position of the container in the tab
	 * @return the position of the container
	 */
	public int getContainerPos() {
		int pos;
		
		Ant[] antplace = this.getAnt();
		for (int x = 0; x <= antplace.length; x++ ) {
			if (antplace[x] instanceof Containing) {
				pos = x;
				return pos;
			}
		}
		return -1;
	}

	/**
	 * Returns an array of the place's bees
	 *
	 * @return an array of the place's bees
	 */
	public Bee[] getBees () {
		return bees.toArray(new Bee[0]);
	}

	/**
	 * Returns a nearby bee, up to the maxDistance ahead. If multiple bees are the same distance, a random bee is chosen
	 *
	 * @param minDistance
	 *            The minimum distance away (in Places) a bee can be. A value of -1 means no min distance
	 * @param maxDistance
	 *            The maximum distance away (in Places) a Bee can be. A value of -1 means no max distance
	 * @return A random nearby bee.
	 */
	public Bee getClosestBee (int minDistance, int maxDistance) {
		Place p = this;
		for (int dist = 0; p != null && dist <= maxDistance; dist++) {
			if (dist >= minDistance && p.bees.size() > 0) {
				return p.bees.get((int) (Math.random() * p.bees.size())); // pick a random bee
			}
			p = p.entrance;
		}
		return null;
	}

	/**
	 * Returns the name of the place
	 *
	 * @return the name of the place
	 */
	public String getName () {
		return name;
	}

	/**
	 * Returns the exit of the place
	 *
	 * @return the exit of the place
	 */
	public Place getExit () {
		return exit;
	}

	/**
	 * Sets the entrance to the place
	 *
	 * @param entrance
	 *            The entrance to the place
	 */
	public void setEntrance (Place entrance) {
		this.entrance = entrance;
	}

	/**
	 * Returns the entrance to the place
	 *
	 * @return the entrance to the place
	 */
	public Place getEntrance () {
		return entrance;
	}

	/**
	 * Adds an ant to the place. If there is already an ant, this method has no effect
	 *
	 * @param ant
	 *            The ant to add to the place.
	 */
	public void addInsect (Ant ant) {
		//if (this.ants == null) {
			this.ants.add(ant);
			ant.setPlace(this);
		//}
		/*else {
			if (this.ants instanceof Containing) {
				Containing cant = (Containing) this.ants;
				cant.addInsectIn(ant);
				this.ants.add(ant);
				ant.setPlace(this);
			}
			else {
				if (ant instanceof Containing) {
					ArrayList<Ant> current_ant = this.ants;
					removeInsect(this.ants.get(0));
					ant.setPlace(this);
					Containing cant = (Containing) ant;
					cant.addInsectIn(current_ant.get(0));
				}
				else {
					System.out.println("Already an ant which can't contain another one in " + this); // report error
				}
			}
		}*/
	}

	/**
	 * Adds a bee to the place
	 *
	 * @param bee
	 *            The bee to add to the place.
	 */
	public void addInsect (Bee bee) {
		bees.add(bee);
		bee.setPlace(this);
	}

	/**
	 * Removes the ant from the place. If the given ant is not in this place, this method has no effect
	 *
	 * @param ant
	 *            The ant to remove from the place
	 */
	public void removeInsect (Ant ant) {
		if(this.getAntContainer() != null) {
			Ant dead_ant = (Ant) this.getAntContainer();
			ants.remove(dead_ant);
			dead_ant.setPlace(null);
		}
		else if (this.ants.contains(ants)) {
			ants.remove(ant);
			ant.setPlace(null);
		}
		else {
			System.out.println(ant + " is not in " + this);
		}
	}		
		
		
		
		/*if (this.getAntContainer() != null) {
			if (this.ants.contains(ant)) {
				this.getAntContainer().removeInsectIn(ant);
				Ant cont_ant = (Ant) this.getAntContainer();
				cont_ant.setPlace(null);
				addInsect(ant);
			}
			else {
				System.out.println(ant + " is not in " + this);
			}
		}
		else {
			if (this.ants.contains(ant)) {
				ants.remove(ant);
				ant.setPlace(null);
			}
 		}*/


	/**
	 * Removes the bee from the place. If the given bee is not in this place, this method has no effect
	 *
	 * @param bee
	 *            The bee to remove from the place.
	 */
	public void removeInsect (Bee bee) {
		if (bees.contains(bee)) {
			bees.remove(bee);
			bee.setPlace(null);
		}
		else {
			System.out.println(bee + " is not in " + this);
		}
	}

	@Override
	public String toString () {
		return name;
	}
}
