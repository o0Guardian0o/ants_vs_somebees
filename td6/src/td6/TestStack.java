package td6;


import java.util.ArrayList;
import td6.LIFOStack;
import td6.Value;
import td6.EmptyStackException;

public class TestStack {
	
	public static void main(String args[]) {
		Stack lifostack = new LIFOStack();
		Value value = new Value("plop", 6);
		
		lifostack.push(value);
		
		try {
			lifostack.pop();
		}
		catch (EmptyStackException exception)
		{
			exception.printStackTrace();
		}
	}

	
	
	
	
}
