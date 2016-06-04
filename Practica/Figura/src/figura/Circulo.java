package figura;

public class Circulo extends Figura{

	private double radio;
	public Circulo(double radio,double x,double y){
		this.radio=radio;
		this.x=x;
		this.y=y;
	}
	
	public void dibujar() {
		
	}

	public void rotar() {
		
	}

	public double getArea() {
		return Math.PI*Math.pow(this.radio,2);
	}

	public double getperimetro() {
		return Math.PI*this.radio*2;
	}
}
