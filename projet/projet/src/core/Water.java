package core;


public class Water extends Place {
	
	public Water(String name, Place exit) {
		super(name,exit);
	}
	
	public void addInsect (Ant ant) {
		if (ant.watersafe) {
			super.addInsect(ant);
		}
	}
}
