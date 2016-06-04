package punto;

public interface Punto {

	public String toString();	
	public boolean equals(Object p);
	public double modulo();
	public double distancia(Object p);
	public String desplazamiento(Object p);
	public double getx();
}
