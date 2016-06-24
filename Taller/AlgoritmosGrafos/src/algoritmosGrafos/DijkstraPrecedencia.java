package algoritmosGrafos;

import java.util.Scanner;

public class DijkstraPrecedencia {
	public String algoritmoDijkstra(long mAdy[][]) {

		int vertices = mAdy.length;
		long matrizAdyacencia[][] = mAdy;
		long minimoCosto;
		long costoTemp;
		long costos[] = new long[vertices];
		int vectorPrecedencias[] = new int[vertices];
		int vectorSolucion[] = new int[vertices];
		int nodoPartida;
		int ultimoVisitado = Integer.MAX_VALUE;
		Scanner scan = new Scanner(System.in);
		String cadena = "";

		System.out.println("Indicar el nodo de partida: \n");
		nodoPartida = scan.nextInt();

		if (nodoPartida < 1 || nodoPartida > vertices) {
			return "El nodo ingresado no existe en el grafo";
		}
		// Preparo los vectores.
		inicializarVector(vectorSolucion, vertices); // VectorSolucion: Sabré
														// qué elementos agregué
														// a mi conjunto
														// solución.
		inicializarVector(vectorPrecedencias, vertices);// VectorPrecedencias:
														// Sabré por que nodo
														// debo pasar para
														// llegar a otro.
		costos = matrizAdyacencia[nodoPartida - 1]; // tendré los costos del
													// nodo que busco.
													// Inicialmente los que
													// están en la matriz de
													// adyacencias.

		vectorSolucion[nodoPartida - 1] = 0;

		for (int nodosRestantes = vertices - 2; nodosRestantes >= 0; nodosRestantes--) {
			minimoCosto = 999999999;
			for (int i = 0; i < vertices; i++) {
				if (vectorSolucion[i] == 1 && costos[i] < minimoCosto) {
					minimoCosto = costos[i];
					ultimoVisitado = i;
				}

			}
			if (ultimoVisitado != Integer.MAX_VALUE) {
				vectorSolucion[ultimoVisitado] = 0;
				// Ahora busco adyacencias
				for (int j = 0; j < vectorSolucion.length; j++) {
					costoTemp = matrizAdyacencia[nodoPartida-1][ultimoVisitado] + matrizAdyacencia[ultimoVisitado][j];
					if (costoTemp < costos[j]) {
						costos[j] = costoTemp;
						vectorPrecedencias[j] = ultimoVisitado+1;

					}
				}
			}

		}

		return mostrarCaminos(cadena, costos, vertices, nodoPartida);

	}

	private String mostrarCaminos(String cad, long[] caminos, int vertices, int nodoPartida) {
		cad += "Los caminos minimos desde el nodo '" + nodoPartida + "' son: \n\n";
		for (int i = 0; i < vertices; i++) {

			cad += "Al nodo '" + (i + 1) + "' ---> " + caminos[i] + "\n";

		}
		return cad;
	}

	private void inicializarVector(int[] caminos, int vertices) {
		for (int i = 0; i < vertices; i++) {
			caminos[i] = 1;

		}

	}

}
