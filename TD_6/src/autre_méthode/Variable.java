package autre_méthode;

public class Variable implements Expression {
	
	private String nom;
	
	public Variable(String namae) {
		this.nom = namae;
	}

	public String getNom() {
		return this.nom;
	}
	
	public void setNom(String namae) {
		this.nom = namae;
	} 
	
	public double evaluer(Contexte c) {
		if (c.estDefinie(this)) {
			return c.valeur(this);
		} else {
			throw new VariableNonDefinieException(this);
		}
	}
	
	public boolean estEvaluable (Contexte c) {
		return false;
	}
	
	public String decompiler() {
		return this.nom;
	}
	
	public Expression reduire(Contexte c) {
		return this;
	}
}
