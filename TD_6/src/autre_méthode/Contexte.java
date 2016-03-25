package autre_méthode;

import java.util.*;

public class Contexte {

	private HashMap<Variable,Double> dictionnaire;
	
	public Contexte() {
		this.dictionnaire = new HashMap<Variable,Double>();
	}
	
	public void fixerValeur(Variable v, double val) {
		this.dictionnaire.put(v, val);
	}
	
	public void supprimerValeur(Variable v) {
		this.dictionnaire.remove(v);
	}
	
	public boolean estDefinie(Variable v) {
		return this.dictionnaire.containsKey(v);
	}
	
	public double valeur(Variable v) {
		return this.dictionnaire.get(v);
	}
	
}
