package tp3;

public abstract class OperadorUnario implements IOperacion{
	
	protected IOperacion operando;
	
	public OperadorUnario(IOperacion operando){
		this.operando = operando;
	}
	
	public abstract double resolver();
}
