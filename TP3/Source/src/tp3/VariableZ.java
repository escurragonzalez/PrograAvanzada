package tp3;

public class VariableZ extends Operando{

	private static VariableZ instance = new VariableZ();
		
	private VariableZ() {
		super(0);
	}
	
	public static VariableZ getInstance(){
		return instance;
	}
		
	public double resolver(){
		return instance.getValor();
	}

}
