package algoritmosGrafos;

public class Warshall {

	public String algoritmoWarshall(long mAdy[][]) {

		int matrizExistencias[][];
		int vertices = mAdy.length;

		matrizExistencias = armarMatrizDeExistencias(mAdy, vertices);

		for (int k = 0; k < vertices; k++) {
			for (int i = 0; i < vertices; i++) {
				for (int j = 0; j < vertices; j++) {
					if (i != j && i != k && j != k) {
						if (matrizExistencias[i][j] != 1) {
							matrizExistencias[i][j] = matrizExistencias[i][k] * matrizExistencias[k][j];

						}
					}

				}

			}
		}

		return mostrarExistenciaDeCaminos(matrizExistencias, vertices);

	}

	private String mostrarExistenciaDeCaminos(int[][] matrizAdyacencia, int vertices) {

		String cadena = null;
		// Armo en la cadena la matriz de existencias de caminos.
		cadena += "La matriz de caminos existentes entre nodos queda de la siguiente forma:\n\n";
		for (int i = 0; i < vertices; i++) {
			for (int j = 0; j < vertices; j++) {
				cadena += "[" + matrizAdyacencia[i][j] + "]";

			}
			cadena += "\n";
		}
		// Ahora indico los caminos que existen y los que no.
		for (int i = 0; i < vertices; i++) {
			for (int j = 0; j < vertices; j++) {
				if (matrizAdyacencia[i][j] == 1) {
					cadena += "De (" + (i + 1) + "--->" + (j + 1) + ") Existe camino.\n";
				} else {
					cadena += "De (" + (i + 1) + "--->" + (j + 1) + ") No Existe camino.\n";
				}
			}
		}
		return cadena;
	}

	// Metodo para armar la matriz de existencias a partir de la de adyacencia.
	public int[][] armarMatrizDeExistencias(long mAdy[][], int vertices) {
		int matrizExistencias[][] = new int[vertices][vertices];

		for (int i = 0; i < vertices; i++) {
			for (int j = 0; j < vertices; j++) {
				if (i!=j) {//Si i es distinto de j, ya que no considero lazos de vectores
					if (mAdy[i][j] != 999999999) { //Si el valor es distinto del que pongo como infiinto, quiere decir que entre i y j hay camino.
													//Ademas asi ya estoy considerando implicitamente que el valor de i y j pueda 
													//ser 0, es decir, que no haya costo en ir de i a j.
						matrizExistencias[i][j] = 1; 
					} else {
						matrizExistencias[i][j] = 0;
					}
				} else {
					matrizExistencias[i][j] = 0;
				}
			}
		}

		return matrizExistencias;

	}

}
