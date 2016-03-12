package core;
import java.util.ArrayList;

import core.AntColony;

public class GamePoint {
	
	private int game_point;
	private int mult_factor;
	
	public GamePoint () {
		game_point = 0;
		mult_factor = 1;
	}
	
	public void setGamePoint (ArrayList<Bee> dead_bees) {
		int new_game_point = 0;
		if (dead_bees != null) {
			for (Bee b : dead_bees) {
				new_game_point += b.getArmorInit() * mult_factor;
			}
			this.game_point = new_game_point;
		}
		else {
			System.out.println("No bees killed !!!");
		}
		
	}
	
	public int getGamePoint () {
		return this.game_point;
	}
	
	public void setMultFactor(int turn) {
		mult_factor = 1 + (turn/10);
	}
	
	public int getMultFactor() {
		return this.mult_factor;
	}
	
	
}
