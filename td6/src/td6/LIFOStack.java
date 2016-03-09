package td6;

import java.util.ArrayList;

public class LIFOStack implements Stack {
	
	public ArrayList<Value> stack;
	
	public LIFOStack() {
		stack = null;
	}
	
	public boolean isEmpty() {
		return (this.stack == null);
	}
	
	public void push(Value v) {
		if (isEmpty()) {
			this.stack = new ArrayList<Value>();
		}
		this.stack.add(v);
	}
	
	public Value pop() 
		throws EmptyStackException
		{
		if (isEmpty()) {
			throw new EmptyStackException();
		}
		else {
			return (Value) this.stack.remove(this.stack.size()-1);
		}
	}
	
	public Value peek() 
		throws EmptyStackException
	{
		if (isEmpty()) {
			throw new EmptyStackException();
		}
		else {
			return (Value) this.stack.get(stack.size()-1);
		}
	}
	
	public ArrayList<Value> getStack() {
		return this.stack;
	}

}
