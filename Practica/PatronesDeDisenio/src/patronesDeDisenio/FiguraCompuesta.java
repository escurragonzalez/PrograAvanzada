package patronesDeDisenio;

import java.util.ArrayList;

public class FiguraCompuesta implements Figura {
	private ArrayList<Figura> figuras;
	
	public FiguraCompuesta() {

			figuras = new ArrayList<Figura>();
	}

	public void agregarFigura(Figura figu) {
			
		figuras.add(figu);
	}

	public double calcularArea(){
	double area=0;
	for(Figura f : figuras){
		area+=f.calcularArea();
			}
	
	return area;
}

}
