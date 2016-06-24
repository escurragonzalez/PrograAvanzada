package algoritmosGrafos;

import java.util.Scanner;

public class Prim {

	public String algoritmoPrim(long mAdy[][]) {

		int vertices = mAdy.length;
		int nodoInicial; // Nodo del que voy a comenzar. Lo ingresa el usuario.
		long minimoCosto, costoTotal = 0;
		String cadena = "";

		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		long matrizAdyacencia[][] = mAdy;
		int nodosVisitados[] = new int[vertices];
		int ultimoVisitado = 0;

		// Inicializo el vector de nodos visitados. Inicialmente serán NO
		// visitados. 0-No visitado. 1-Visitado
		for (int i = 0; i < vertices; i++) {
			nodosVisitados[i] = 0;

		}
		System.out.println("¿Por qué nodo comenzar?\n");
		nodoInicial = scan.nextInt();

		if (nodoInicial > vertices || nodoInicial < 1) { // Si ingresé un número
															// mayor a la
															// cantidad real de
															// vértices en el
															// grafo
			return "Ingresó un número de nodo inexistente en el grafo.";
		} else {
			nodosVisitados[nodoInicial - 1] = 1;
		}

		// Hasta acá lo único que se hizo fue decir de qué nodo comenzar. Ahora
		// armamos el camino.
		// Teniendo en cuenta tenemos un nodo menos por recorrer (no se cuenta
		// el que empieza).

		cadena += nodoInicial + ""; // Voy concatenando los nodos que se
									// visitaron para luego retornarlos a la
									// salida.

		for (int cantNodosRestantes = 0; cantNodosRestantes < vertices - 1; cantNodosRestantes++) {
			minimoCosto = 999999999;
			for (int i = 0; i < vertices; i++) {
				if (nodosVisitados[i] == 1) {
					for (int j = 0; j < vertices; j++) {
						if (i != j && nodosVisitados[j] == 0) { // el nodo j no
																// fue visitado
							if (matrizAdyacencia[i][j] < minimoCosto) {
								minimoCosto = matrizAdyacencia[i][j];
								ultimoVisitado = j;
							}

						}

					}
				}

			}
			if (minimoCosto != 999999999) {
				nodosVisitados[ultimoVisitado] = 1;
				costoTotal += minimoCosto;
				cadena += ", " + (ultimoVisitado+1);
			}
		}
		return mostrarNodos(cadena, matrizAdyacencia, vertices, costoTotal);
		
	}

	private String mostrarNodos(String cadena, long matrizAdyacencia[][], int vertices, long costoTotal) {
		String cad = null;

		cad += "La matriz de adyacencia original es la siguiente:\n\n";
		for (int i = 0; i < vertices; i++) {
			for (int j = 0; j < vertices; j++) {
				cad += "[" + matrizAdyacencia[i][j] + "]";
			}
			cad+="\n\n";
		}
		cad+="El camino más corto que recorre cada vértice/nodo sin repeticiones es el siguiente.\n"+cadena+
				"\nSu costo es: "+costoTotal;
		
		return cad;

	}

}
