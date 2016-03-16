package core;

public class InfinitHive extends Hive {
	


	
	public InfinitHive(int armor) {
		super(armor);
	}

	public static Hive makeNewHive(int armor, int number_wave, int counter) {
		InfinitHive hive = new InfinitHive(armor);
		for (int i=1; i <= number_wave; i++) {
			hive.addWave(counter+i-1,i);
		}
		return (Hive) hive;	
	}
	

	

}
