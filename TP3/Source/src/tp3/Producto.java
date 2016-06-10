package tp3;

public class Producto extends OperadorBinario {

	public Producto(IOperacion op1, IOperacion op2) {
		super(op1, op2);
	}
	
	public double resolver(){
		return this.operando1.resolver()*this.operando2.resolver();
		
	}

}
