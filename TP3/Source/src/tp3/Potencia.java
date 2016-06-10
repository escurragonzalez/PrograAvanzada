package tp3;

public class Potencia extends OperadorBinario {

	public Potencia(IOperacion op1, IOperacion op2) {
		super(op1, op2);
	}
	
	public double resolver(){
		return Math.pow(this.operando1.resolver(),this.operando2.resolver());
		
	}

}
