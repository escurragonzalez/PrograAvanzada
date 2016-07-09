package tareasPreliminares;

import grafo.GeneradorRegularesPorcentaje;

public class Test {

	public static void main(String[] args) {
		int n=1000;
		double porcentaje=75;
		GeneradorRegularesPorcentaje generadorRegularesPorcentaje= new GeneradorRegularesPorcentaje(n, porcentaje);
		double aristasMax=(n*(n-1)/2);
		double porcentajeUnGradoMenos=(((double)n*(generadorRegularesPorcentaje.getGradoMaxima()-1)/2)/aristasMax);
		double porcentajeCalculado=(((double)n*(generadorRegularesPorcentaje.getGradoMaxima())/2)/aristasMax);
		double porcentajeUnGradoMas=(((double)n*(generadorRegularesPorcentaje.getGradoMaxima()+1)/2)/aristasMax);
		//generadorRegularesPorcentaje.mostrarAdyacencia();//Usado en Debug
		System.out.println();
		generadorRegularesPorcentaje.esccribirArchivo("01_generadorRegularesPorcentaje.in");

	}

}
