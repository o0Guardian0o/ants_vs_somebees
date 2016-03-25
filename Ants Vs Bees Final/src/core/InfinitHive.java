package core;

public class InfinitHive extends Hive {
	


	/**
	 * Construtor of the Infinite Hive !
	 * 
	 * @param armor the bees' armor
	 */
	public InfinitHive(int armor) {
		super(armor);
	}
	/**
	 * Makes a new hive to continue the infinite hive and permit the system to increase the difficulty of the game
	 * @param armor the bees'armor of the new wave
	 * @param number_wave the number wave in this new hive !
	 * @param counter a counter which permit to reference the start-moment of each wave
	 * @return a new hive !
	 */
	public static Hive makeNewHive(int armor, int number_wave, int counter) {
		InfinitHive hive = new InfinitHive(armor);
		for (int i=1; i <= number_wave; i++) {
			hive.addWave(counter+i-1,i);
		}
		return (Hive) hive;	
	}
	

	

}
