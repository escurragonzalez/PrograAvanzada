package tp3;

public class Suma extends OperadorBinario{
	
	public Suma(IOperacion sumando1, IOperacion sumando2){
		super(sumando1,sumando2);
	}
	
	public double resolver() {
		return operando1.resolver() + operando2.resolver();
	}

}
