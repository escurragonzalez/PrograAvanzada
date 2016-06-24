package algoritmosGrafos;

import java.util.Scanner;

public class Dijkstra {

	@SuppressWarnings("resource")
	public String algoritmoDijkstra(long mAdy[][]) {

		int vertices = mAdy.length;
		long matrizAdyacencia[][] = mAdy;
		float minimoCosto;
		float caminoDirecto, caminoIndirecto;
		long caminos[] = new long[vertices];
		int nodoPartida;
		Scanner scan = new Scanner(System.in);
		String cadena = "";

		System.out.println("Indicar el nodo de partida: \n");
		nodoPartida = scan.nextInt();

		if (nodoPartida < 1 || nodoPartida > vertices) {
			return "El nodo ingresado no existe en el grafo";
		}

		inicializarCaminos(caminos, vertices);

		for (int k = 0; k < vertices; k++) {
			for (int i = 0; i < vertices; i++) {
				caminoDirecto = matrizAdyacencia[nodoPartida-1][i];
				caminoIndirecto = matrizAdyacencia[nodoPartida-1][k] + matrizAdyacencia[k][i];
				minimoCosto = Math.min(caminoDirecto, caminoIndirecto);

				
					if (minimoCosto == caminoIndirecto) {
						matrizAdyacencia[nodoPartida-1][i] = (long) minimoCosto;

					}
					caminos[i] = (long) minimoCosto;// En la fila de la matriz
													// ya me quedan los costos,
													// pero los separo para
													// organizar.
				

			}

		}

		return mostrarCaminos(cadena, caminos, vertices, nodoPartida);

	}

	private String mostrarCaminos(String cad, long[] caminos, int vertices, int nodoPartida) {
		cad += "Los caminos minimos desde el nodo '" + nodoPartida + "' son: \n\n";
		for (int i = 0; i < vertices; i++) {
			
				cad += "Al nodo '" + (i + 1) + "' ---> " + caminos[i] + "\n";
			
		}
		return cad;
	}

	private void inicializarCaminos(long[] caminos, int vertices) {
		for (int i = 0; i < vertices; i++) {
			caminos[i] = 0;

		}

	}

}
