package algoritmosGrafos;

public class Floyd {

	public String algoritmoFloyd(long[][] mAdy) {

		int vertices = mAdy.length; // Cant de vertices/nodos del grafo
		float temp1, temp2, temp3, temp4, minimo;
		long matrizAdyacencia[][] = mAdy;
		String matrizCaminos[][] = new String[vertices][vertices]; // Matriz que
																	// indica
																	// qué nodo
																	// debe
																	// visitar
																	// para
																	// llegar a
																	// tal otro.
		String matrizCaminosRecorridos[][] = new String[vertices][vertices]; // Matriz que contiene el camino de nodos a realizar en cada celda
																				// para
																				// llegar
																				// de
																				// "i"
																				// a
																				// "j".
		String caminoRecorrido = "";

		inicializarMatrizString(matrizCaminos, vertices);

		for (int k = 0; k < vertices; k++) {
			for (int i = 0; i < vertices; i++) {
				for (int j = 0; j < vertices; j++) {

					temp1 = matrizAdyacencia[i][j]; // Guardo el costo directo
													// de ir del nodo "i" al
													// nodo "j"
					temp2 = matrizAdyacencia[i][k]; // Guardo el costo de ir de
													// "i" a "k".
					temp3 = matrizAdyacencia[k][j]; // Guardo el costo de ir de
													// "k" a "j".
					temp4 = temp2 + temp3; // Guardo el costo total de ir de "i"
											// a "j" pasando por "k".
					minimo = Math.min(temp1, temp4); // Guardo el minimo.
					// Ahora necesito ir armando el camino.

					if (temp1 != temp4) {
						if (minimo == temp4) { // Si el costo minimo es el
												// camino
												// alternativo
							matrizCaminos[i][j] = k + "";// Guardo el nodo por
															// el
															// que debo pasar
															// para
															// llegar de "i" a
															// "j".
															// Lo haré para
															// todos
															// los nodos. Si un
															// nodo
															// llega directo,
															// entonces en la
															// matriz
															// habrá "" (vacío)
															// en
															// el valor
															// contenido.
							matrizAdyacencia[i][j] = (long) minimo; // Guardo el
																	// nuevo
																	// minimo,
																	// en el
																	// caso de
																	// que sea
																	// por
																	// caminos
																	// alternativos..sino,
																	// se que el
																	// minimo
																	// será
																	// el del
																	// camino
																	// directo.

						}
					}

				}

			}

		}
		// Una vez armada la matriz de caminos, armaremos los caminos a
		// recorrer para llegar de un vertice/nodo a otro.
		for (int i = 0; i < vertices; i++) {
			for (int j = 0; j < vertices; j++) {
				matrizCaminosRecorridos[i][j] = caminosRecorridos(i, j, matrizCaminos, caminoRecorrido);

			}

		}

		return mostrarCaminos(matrizAdyacencia, matrizCaminosRecorridos, vertices);

	}// Fin del algoritmo

	private String mostrarCaminos(long[][] matrizAdyacencia, String[][] matrizCaminosRecorridos, int vertices) {

		String cadena = "";

		// Primero armo en el String la matriz de adyacencias final que la voy a
		// mostrar.

		cadena += "La matriz de adyacencia del grafo queda de la siguiente forma: \n";
		for (int i = 0; i < vertices; i++) {
			for (int j = 0; j < vertices; j++) {
				cadena += "[" + matrizAdyacencia[i][j] + "]";

			}
			cadena += "\n";
		}
		cadena += "\nLos caminos minimos serán: \n\n";
		// Luego armo en el String los caminos a mostrar.
		for (int i = 0; i < vertices; i++) {
			for (int j = 0; j < vertices; j++) {
				if (matrizAdyacencia[i][j] != 999999999) { // Ya que en caso de
															// ser 999999999 no
															// hay camino para
															// ese nodo.
					if (i != j) { // Si i es distinto de j, es decir si no
									// hablamos de ir al mismo nodo
						if (matrizCaminosRecorridos[i][j].equals("")) { // Si no
																		// hay
																		// nodos
																		// intermedios
																		// para
																		// llegar
																		// de i
																		// a j

							cadena += "De (" + (i + 1) + "---->" + (j + 1) + ") Irse por...(" + (i + 1) + ", " + (j + 1)
									+ ")\n";

						} else { // En el caso de que haya nodos intermedios
									// para ir de i a j.
							cadena += "De (" + (i + 1) + "--->" + (j + 1) + ") Irse por...(" + (i + 1) + ", "
									+ matrizCaminosRecorridos[i][j] + (j + 1) + ")\n";
						}

					}
				}

			}

		}

		return cadena;
	}

	private String caminosRecorridos(int i, int j, String[][] matrizCaminos, String caminoRecorrido) {
		if (matrizCaminos[i][j].equals("")) {
			return "";
		}

		caminoRecorrido += caminosRecorridos(i, Integer.parseInt(matrizCaminos[i][j].toString()), matrizCaminos,
				caminoRecorrido) + (Integer.parseInt(matrizCaminos[i][j].toString()) + 1) + ", ";

		return caminoRecorrido;

	}

	private void inicializarMatrizString(String[][] matrizCaminos, int v) {
		for (int i = 0; i < v; i++) {
			for (int j = 0; j < v; j++) {
				matrizCaminos[i][j] = "";

			}
		}

		// TODO Auto-generated method stub

	}

}
