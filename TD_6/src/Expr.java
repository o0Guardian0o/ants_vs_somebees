
public class Expr {
	
	private Expr fg;
	private Expr fd;
	private double v;
	private char op;
	
	public Expr(double valeur) {
		this.v = valeur;
	}
	
	public Expr(char op, Expr fg, Expr fd) {
		this.op = op;
		this.fg = fg;
		this.fd = fd;
	}
	
	public double evaluer() {
		double a = 0.0;
		switch (this.op) {
		case '+' :
			a = this.fg.evaluer() + this.fd.evaluer();
			break;
		case '-' :
			a = this.fg.evaluer() - this.fd.evaluer();
			break;
		case '*' :
			a = this.fg.evaluer() * this.fd.evaluer();
			break;
		case '/' :
			a = this.fg.evaluer() / this.fd.evaluer();
			break;
		default :
			a =  this.v;
			break;
		}
		return a;
		
	}
	
	public String decompiler() {
		String a ="";
		switch (this.op) {
		case '+' :
			a += "(" + this.fg.decompiler() + ") + ("  + this.fd.decompiler() + ")";
			break;
		case '-' :
			a += "(" + this.fg.decompiler() + ") - ("  + this.fd.decompiler() + ")";
			break;
		case '*' :
			a += "(" + this.fg.decompiler() + ") * ("  + this.fd.decompiler() + ")";
			break;
		case '/' :
			a += "(" + this.fg.decompiler() + ") / ("  + this.fd.decompiler() + ")";
			break;
		default :
			a += this.v;
			break;
		}
		return a;
	}
}
