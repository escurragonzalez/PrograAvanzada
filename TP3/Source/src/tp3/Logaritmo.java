package tp3;

public class Logaritmo extends OperadorUnario {
	
	public Logaritmo(IOperacion operando){
		super(operando);
	}
	
	@Override
	public double resolver(){
		return Math.log(this.operando.resolver());
	}

}
