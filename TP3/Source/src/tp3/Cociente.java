package tp3;

public class Cociente extends OperadorBinario {

	public Cociente(IOperacion op1, IOperacion op2) {
		super(op1, op2);
	}
	
	public double resolver(){
		try{
			return this.operando2.resolver()/this.operando1.resolver();
		}catch(Exception e){
			e.printStackTrace();
		}
		return 0;
	}

}
