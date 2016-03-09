package exo4;

public class IterateurDesPairs {

	private int[] tab;
	private int pos;
	
	public IterateurDesPairs(int[] tab) {
		this.tab = tab;
		pos = 0;
	}
	
	public int suivant() {
		pos = indiceDuSuivant();
		return tab[pos];
	}
	
	public int indiceDuSuivant() {
		int indice = pos+1;
		while ((indice< tab.length) && (tab[indice] % 2 != 0)) {
			indice++;
		}
		
		return indice;
	}
	
	public boolean aUnSuivant() {
		int indice = indiceDuSuivant();
		return (pos<indice) && (indice < tab.length);
 	}
}
