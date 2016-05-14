package patronesDeDisenio;

public class Triangulo implements Figura{
	private double base;
	private double altura;

	public Triangulo(){
		base=1;
		altura=1;		
	}
	
	

	public double getBase() {
		return base;
	}



	public void setBase(double base) {
		this.base = base;
	}



	public double getAltura() {
		return altura;
	}



	public void setAltura(double altura) {
		this.altura = altura;
	}



	@Override
	public double calcularArea() {
		
		return (this.base)*(this.altura)/2;
	}
	

}
