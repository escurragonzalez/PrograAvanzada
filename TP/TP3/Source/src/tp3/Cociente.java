package tp3;

public class Cociente extends OperadorBinario {

	public Cociente(IOperacion op1, IOperacion op2) {
		super(op1, op2);
	}
	
	public double resolver(){
		try{
			if(this.operando2.resolver()==0)
				return Double.NaN;
			return this.operando1.resolver()/this.operando2.resolver();
		}catch(Exception e){
			e.printStackTrace();
		}
		return 0;
	}

}
