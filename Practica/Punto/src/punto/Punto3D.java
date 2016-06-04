package punto;

public class Punto3D extends Punto2D {

	private double z;

	public Punto3D(double i, double j, int k) {
		super(i,j);
		this.z=k;
	}	
	
	public String toString(){
		return String.valueOf(x)+" "+String.valueOf(y)+" "+String.valueOf(z);
	}
	
	public boolean equals(Object p){
			if(p==null)
				return false;
			if(!(p instanceof Punto3D ))
				return false;
			Punto3D punto3D = (Punto3D)p;
			if(x==punto3D.x && y==punto3D.y && z==punto3D.z)
				return true;
			else
				return false;
	}

	public double modulo() {
		double res = Math.sqrt(Math.pow(x,2)+Math.pow(y, 2)+Math.pow(z, 2));
		return res;
	}
	
	public double distancia(Object p) {
		if(p==null)
			return -1;
		if(!(p instanceof Punto3D))
			return -1;
		Punto3D punto3D =  (Punto3D)p;
		double res = Math.sqrt(Math.pow(x-punto3D.x,2)+Math.pow(y-punto3D.y,2)+Math.pow(z-punto3D.z,2));
		return res;
	}

	public String desplazamiento(Object p) {
		if(p==null)
			return "";
		if(!(p instanceof Punto3D))
			return "";
		Punto3D p3D = (Punto3D)p;
		this.x+=p3D.x;
		this.y+=p3D.y;
		this.z+=p3D.z;
		return this.toString();
	}
}
