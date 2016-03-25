package autre_méthode;

public abstract class Binaire implements Expression {
	
	private Expression operandeGauche;
	private Expression operandeDroite;
	private String symbole;
	
	public Binaire(Expression opg, Expression opd) {
		this.operandeDroite = opd;
		this.operandeGauche = opg;
	}
	
	public Expression operandeGauche() {
		return this.operandeGauche;
	}
	
	public Expression operandeDroite() {
		return this.operandeDroite;
	}
	
	public boolean estEvaluable (Contexte cxt) {
		return (this.operandeGauche.estEvaluable(cxt) && this.operandeDroite.estEvaluable(cxt));
	}
	
	public double evaluer(Contexte ctx) {
		if (this.estEvaluable(cxt)) {
		}
	}
	
	public String decompiler(Contexte c) {
		return "(" + this.operandeGauche.decompiler() + symbole() + this.operandeDroite.decompiler() + ")";
	}
	
	protected abstrac double calculer (double evaluer, double evaluer)
	
	public Expression reduire(Contexte c) {
		this.
	}
}
