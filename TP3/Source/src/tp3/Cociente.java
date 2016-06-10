package tp3;

public class Cociente extends OperadorBinario {

	public Cociente(IOperacion op1, IOperacion op2) {
		super(op1, op2);
	}
	
	public double resolver(){
		return this.operando1.resolver()/this.operando2.resolver();
		
	}

}
