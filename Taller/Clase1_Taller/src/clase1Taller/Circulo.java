package clase1Taller;

public class Circulo {

	private Punto centro;
	private double radio;

	public Circulo (Punto c, double r)
	{
		this.centro=c;
		this.radio=r;
	}
	
	
	public double getRadio() {
		return radio;
	}
	
	public boolean contiene (Punto pun)
	{
		//boolean respuesta;
		double distancia;
		
		//distancia= Math.sqrt(Math.pow((this.centro.getX()-pun.getX()),2)+Math.pow((this.centro.getY()-pun.getY()),2));
		
		distancia=this.centro.distancia(pun);
		
		System.out.println("*** La distancia entre ambos puntos es: "+distancia+" ***");
		
		
		if (distancia <= this.radio)
			return true;
		else
			return false;
			
		//return respuesta;
	}
	
	public boolean intersectaCon(Circulo circ)
	{
		double distancia;
		distancia= Math.sqrt(Math.pow((this.centro.getX()-circ.centro.getX()),2)+Math.pow((this.centro.getY()-circ.centro.getY()),2));
		
		if (distancia <= (this.radio+circ.radio))
			return true;
		else
			return false;
		
	}
}
