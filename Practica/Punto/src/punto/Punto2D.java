package punto;

public class Punto2D implements Punto{
	protected double x;
	protected double y;
	public Punto2D(double i, double j) {
		// TODO Auto-generated constructor stub
		x=i;
		y=j;
	}
	
	public double getx(){
		return this.x;
	}
	public String toString(){
		return String.valueOf(x)+" "+String.valueOf(y);
	}
	
	public boolean equals(Object p){
			if(p==null)
				return false;
			if(!(p instanceof Punto2D))
				return false;
			Punto2D p2D = (Punto2D)p;
			if(x==p2D.x && y==p2D.y)
			return true;
		else
			return false;
	}

	public double modulo() {
		double res = Math.sqrt(Math.pow(x,2)+Math.pow(y, 2));
		return res;
	}

	public double distancia(Object p) {
		if(p==null)
			return -1;
		if(!(p instanceof Punto2D))
			return -1;
		Punto2D p2D = (Punto2D)p;
		double res = Math.sqrt(Math.pow(x-p2D.x,2)+Math.pow(y-p2D.y,2));
		return res;
	}


	public String desplazamiento(Object p) {
		if(p==null)
			return "";
		if(!(p instanceof Punto2D))
			return "";
		Punto2D p2D = (Punto2D)p;
		this.x+=p2D.x;
		this.y+=p2D.y;
		return this.toString();
	}
	
	
	

}
