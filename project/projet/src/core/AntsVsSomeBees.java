package core;

import core.GamePoint;

/**
 * A driver for the Ants vs. Some-Bees game
 */
public class AntsVsSomeBees {

	public static void main (String[] args) {
		AntColony colony = new AntColony(5, 8, 3,20); // specify the colony ]tunnels, length, moats, food]
		Hive hive = Hive.makeInsaneHive(); // specify the attackers (the hive)
		GamePoint gamepoint = new GamePoint();
		new AntGame(colony, hive, gamepoint); // launch the game
	}
}
