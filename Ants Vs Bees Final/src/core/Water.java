package core;


public class Water extends Place {
	
	/**
	 * Constructor of the Water place
	 * 
	 * @param name The name of the Water place
	 * @param exit The exit of the Water place
	 */
	public Water(String name, Place exit) {
		super(name,exit);
	}
	
	@Override
	public void addInsect (Ant ant) {
		if (ant.watersafe) {
			super.addInsect(ant);
		}
	}
}
