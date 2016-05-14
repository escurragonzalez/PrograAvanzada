package patronesDeDisenio;

public class Cuadrado implements Figura{
	private double lado;

	public Cuadrado(){
		lado=1;
		
	}

	
	
	public double getLado() {
		return lado;
	}



	public void setLado(double lado) {
		this.lado = lado;
	}



	@Override
	public double calcularArea() {
		
		return (Math.pow(this.lado, 2));
	}
	

}