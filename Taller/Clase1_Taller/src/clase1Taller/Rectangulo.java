package clase1Taller;

public class Rectangulo {
	
	private double base;
	private double altura;
	
	private Punto referencia;
	
	public Rectangulo (double b, double h, Punto r)
	{
		this.base=b;
		this.altura=h;
		this.referencia=r;
	}
	
	public double getArea()
	{
		return (this.base*this.altura);
	}

}
