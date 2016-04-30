package clase1Taller;

public class Punto {

	private double x;
	private double y;
	
	//CONSTRUCTOR PARAMETRIZADO
	
	public Punto (double x,double y)
	{
		this.x=x;
		this.y=y;
	}
	
	public Punto (Punto p)
	{
		this.x=p.x;
		this.y=p.y;
	}
	
	//Getters y setters
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
	
	public double distancia(Punto pun)
	{
		double distancia;
		
		distancia= Math.sqrt(Math.pow((this.getX()-pun.getX()),2)+Math.pow((this.getY()-pun.getY()),2));
		
		return distancia;
	}
	
	
}
