package patronesDeDisenio;

public abstract class Test {

	public static void main(String[] args) {
		// PATRON SINGLETON
		
		HistorialDeAccesos.getInstance().registrarEvento("salio juan");
		HistorialDeAccesos.getInstance().registrarEvento("entro el pata de lana");
		HistorialDeAccesos objeto=HistorialDeAccesos.getInstance();
		objeto.registrarEvento("pobre juan se la pasa laburando");
		System.out.println(objeto.toString());
		
		//PATRON COMPOSITE
		/*
		FiguraCompuesta vagon=new FiguraCompuesta();
		
		Figura figura1=new Cuadrado();
		
		Figura figura2=new Circulo();
		Figura figura3=new Triangulo();
	
		vagon.agregarFigura(figura1);
		vagon.agregarFigura(figura2);
		vagon.agregarFigura(figura3);
		
	System.out.println("El área por separado es: "+(figura1.calcularArea()+figura2.calcularArea()+figura3.calcularArea()));
	System.out.println("El área compuesta es: "+vagon.calcularArea());
	*/
	}

}
