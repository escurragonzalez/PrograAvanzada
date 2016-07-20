package grafo;

public class Test {

	public static void main(String[] args) {
		int n=10;
		double porcentaje=50;
		GeneradorRegularesPorcentaje generadorRegularesPorcentaje= new GeneradorRegularesPorcentaje(n, porcentaje);
		double aristasMax=(n*(n-1)/2);
		double porcentajeUnGradoMenos=(((double)n*(generadorRegularesPorcentaje.getGradoMaxima()-1)/2)/aristasMax);
		double porcentajeCalculado=(((double)n*(generadorRegularesPorcentaje.getGradoMaxima())/2)/aristasMax);
		double porcentajeUnGradoMas=(((double)n*(generadorRegularesPorcentaje.getGradoMaxima()+1)/2)/aristasMax);
		//generadorRegularesPorcentaje.mostrarAdyacencia();//Usado en Debug
		System.out.println();
		generadorRegularesPorcentaje.escribirArchivo("Lote de Prueba\\RegularAl50Porciento.in");
		
		GrafoNDNP prueba=new GrafoNDNP("Lote de Prueba\\RegularAl50Porciento.in");
		try {
			
			prueba.welsh_Powel();
			prueba.calcularCantidadColores();
			
			
		prueba.escribirArchivo("Lote de Prueba\\RegularAl50PorcientoColoreado.out");	
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
