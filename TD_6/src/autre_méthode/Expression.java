package autre_méthode;

public interface Expression {
	
	public String decompiler();
	
	public Expression reduire(Contexte c);
	
	public double evaluer(Contexte c);
	
	public boolean estEvaluable(Contexte c);
	
}
