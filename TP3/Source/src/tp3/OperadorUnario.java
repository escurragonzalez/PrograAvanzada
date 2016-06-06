package tp3;

public abstract class OperadorUnario implements IOperacion{
	
	protected IOperacion operando1;
	
	public abstract double resolver();
}
