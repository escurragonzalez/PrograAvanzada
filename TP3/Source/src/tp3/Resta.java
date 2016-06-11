package tp3;

public class Resta extends OperadorBinario{
	
	public Resta(IOperacion operando1, IOperacion operando2) {
		super(operando1, operando2);
	}

	public double resolver() {
		return operando2.resolver() - operando1.resolver();
	}

}
