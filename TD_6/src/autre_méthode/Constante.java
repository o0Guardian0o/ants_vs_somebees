package autre_méthode;

public class Constante implements Expression {
	
	private double valeur;
	
	public Constante(double val) {
		this.valeur = val;
	}

	public double getValeur() {
		return valeur;
	}

	public void setValeur(double valeur) {
		this.valeur = valeur;
	}
	
	public String decompiler() {
		if (this.valeur < 0) {
			return "(" + Double.toString(this.valeur);
		}
		return Double.toString(this.valeur);
	}
	
	public Expression reduire(Contexte c) {
		return this;
	}
	
	public double evaluer(Contexte c) {
		return this.valeur;
	}
	
	public boolean estEvaluable(Contexte c) {
		return true;
	}
}
