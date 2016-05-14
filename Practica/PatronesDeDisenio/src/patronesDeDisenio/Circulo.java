package patronesDeDisenio;

public class Circulo implements Figura{
	private double radio;

	public Circulo(){
		radio=1;
		
	}
	
	public double getRadio() {
		return radio;
	}

	public void setRadio(double radio) {
		this.radio = radio;
	}

	public double calcularArea() {
		
		return (Math.PI)*(Math.pow(this.radio, 2));
	}


}
