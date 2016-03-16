
public class TestExpr {
	
	public static void main(String args[]) {
		
		Expr expr1 = new Expr(9);
		Expr expr2 = new Expr(5);
		Expr expr3 = new Expr(3);
		
		Expr expr4 = new Expr('+',expr1,expr2);
		Expr expr5 = new Expr('-',expr2,expr3);
		Expr expr6 = new Expr('/',expr4,expr5);
		
		String a = expr6.decompiler();
		System.out.println(a + " = " + expr6.evaluer());
	} 
}
