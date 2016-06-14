package tp3;

public class Logaritmo extends OperadorUnario {
	
	public Logaritmo(IOperacion operando){
		super(operando);
	}
	
	@Override
	public double resolver(){
		if(this.operando.resolver()<=0)
			return Double.NaN;
		return Math.log(this.operando.resolver());
	}

}
