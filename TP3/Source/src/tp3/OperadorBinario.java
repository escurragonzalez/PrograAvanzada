package tp3;

public abstract class OperadorBinario implements IOperacion{
	
	protected IOperacion operando1;
	protected IOperacion operando2;
	
	public OperadorBinario(IOperacion operando1, IOperacion operando2){
		this.operando1 = operando1;
		this.operando2 = operando2;
		
	}


	public abstract double resolver();
}