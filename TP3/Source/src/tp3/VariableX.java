package tp3;

public class VariableX extends Operando{

	private static VariableX instance = new VariableX();
		
	private VariableX() {
		super(0);
	}
	
	public static VariableX getInstance(){
		return instance;
	}
		
	public double resolver(){
		return instance.getValor();
	}

}
