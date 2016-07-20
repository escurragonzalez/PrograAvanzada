package tp3;

public abstract class  Operando implements IOperacion {
	
	private double valor;
	
	public Operando(double valor){
		this.valor=valor;
	}
	
	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public double resolver() {
		return this.valor;
	}
	
}
