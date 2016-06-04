package figura;

public class Rectangulo extends Figura{

	private double ancho;
	private double alto;

	public Rectangulo (double ancho, double alto,double x,double y){
		this.alto=alto;
		this.ancho=ancho;
		this.x=x;
		this.y=y;
	}
	
	public void dibujar() {
		
	}

	public void rotar() {
		double aux=this.ancho;
		this.ancho=this.alto;
		this.alto=aux;
	}

	public double getArea() {
		return this.alto*this.ancho;
	}

	public double getperimetro() {
		return this.alto*2+this.ancho*2;
	}

}
