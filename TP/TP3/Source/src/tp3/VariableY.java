package tp3;

public class VariableY extends Operando{

	private static VariableY instance = new VariableY();
		
	private VariableY() {
		super(0);
	}
	
	public static VariableY getInstance(){
		return instance;
	}
		
	public double resolver(){
		return instance.getValor();
	}

}
