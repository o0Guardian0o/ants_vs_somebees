package core;
import java.util.ArrayList;



public class GamePoint {
	
	private int game_point; //the number of point won
	private int mult_factor; 
	
	/**
	 * Construtor of the instance of GamePoint
	 */
	public GamePoint () {
		game_point = 0;
		mult_factor = 1;
	}
	/**
	 * Calculate the current gamepoint and put it in the variable game_point
	 * @param dead_bees a list of the bees which are currently dead
	 */
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
	/**
	 * Get the variable game_point
	 * @return the variable game_point
	 */
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
