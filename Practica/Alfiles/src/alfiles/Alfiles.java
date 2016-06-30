package alfiles;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import pilaCola.ColaDinamica;
import pilaCola.NodoDato;

public class Alfiles {

	private int[][] matrizTablero;
	private int ordenTablero;
	Grafo grafo = null;

	public void leerArchivo(String ruta) {

		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;
		String linea;
		String[] lineaSplit;

		try {

			archivo = new File(ruta);
			fr = new FileReader(archivo);
			br = new BufferedReader(fr);

			if ((linea = br.readLine()) == null) {
				fr.close();
				throw new Exception();
			}
			// Leo el orden del tablero
			this.ordenTablero = Integer.parseInt(linea);
			// Creo el tablero, la cant de nodos y la matriz de adyacencia.
			this.matrizTablero = new int[this.ordenTablero][this.ordenTablero];
			int cantNodosGrafo = this.ordenTablero * this.ordenTablero;
			grafo = new Grafo(cantNodosGrafo);

			for (int i = 0; i < this.ordenTablero; i++) {
				linea = br.readLine();
				lineaSplit = linea.split(" ");
				for (int j = 0; j < this.ordenTablero; j++) {
					this.matrizTablero[i][j] = Integer.parseInt(lineaSplit[j]);

				}

			}

			// Guardo la posicion del alfil.
			int posXAlfil, posYAlfil, nroNodo;
			linea = br.readLine();
			lineaSplit = linea.split(" ");
			posXAlfil = Integer.parseInt(lineaSplit[0]);
			posYAlfil = Integer.parseInt(lineaSplit[1]);
			nroNodo = posXAlfil * this.ordenTablero + posYAlfil;

			int posXdestino, posYdestino, nroNodoDestino;
			linea = br.readLine();
			lineaSplit = linea.split(" ");
			posXdestino = Integer.parseInt(lineaSplit[0]);
			posYdestino = Integer.parseInt(lineaSplit[1]);
			nroNodoDestino = posXdestino * this.ordenTablero + posYdestino;

			setearMatrizAdyacenciaDefault(grafo.matrizAdyacencia);

			int camino = busquedaEnAnchura(nroNodo, nroNodoDestino);
			System.out.println(camino);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void setearMatrizAdyacenciaDefault(Integer[][] matrizAdyacencia) {

		for (int i = 0; i < this.ordenTablero; i++) {
			for (int j = 0; j < this.ordenTablero; j++) {
				if (this.matrizTablero[i][j] == 0) {
					marcarAdyacenciaSudeste(i, j, i + 1, j + 1);
					marcarAdyacenciaSudoeste(i, j, i + 1, j - 1);
				}

			}

		}

	}

	private void marcarAdyacenciaSudeste(int i, int j, int k, int l) {
		if (k < this.ordenTablero && l < this.ordenTablero) {
			if (this.matrizTablero[k][l] == 0) {
				int nodoOrigen = i * this.ordenTablero + j;
				int nodoDestino = k * this.ordenTablero + l;
				this.grafo.matrizAdyacencia[nodoOrigen][nodoDestino] = 1;
				this.grafo.matrizAdyacencia[nodoDestino][nodoOrigen] = 1;
				marcarAdyacenciaSudeste(i, j, k + 1, l + 1);
			}

		}

	}

	private void marcarAdyacenciaSudoeste(int i, int j, int k, int l) {
		if (k < this.ordenTablero && l >= 0) {
			if (this.matrizTablero[k][l] == 0) {
				int nodoOrigen = i * this.ordenTablero + j;
				int nodoDestino = k * this.ordenTablero + l;
				this.grafo.matrizAdyacencia[nodoOrigen][nodoDestino] = 1;
				this.grafo.matrizAdyacencia[nodoDestino][nodoOrigen] = 1;
				marcarAdyacenciaSudoeste(i, j, k + 1, l - 1);
			}

		}

	}

	Integer busquedaEnAnchura(int origen, int destino) {

		ColaDinamica cola = new ColaDinamica();
		int costo = 0;
		int[] nodosVisitados = new int[this.grafo.cantNodos];

		cola.agregarAListaAlfinal(new NodoDato(origen, costo));

		while (!cola.estaVacia()) {
			NodoDato primero = cola.sacarDeLista();
			costo = primero.getCosto();
			if (primero.getValor() == destino)
				return primero.getCosto();

			encolarHijos(primero.getValor(), costo, cola, nodosVisitados);

		}

		return 0;

	}

	private void encolarHijos(Integer primero, Integer costo, ColaDinamica cola, int[] nodosVisitados) {
		for (int i = 0; i < this.grafo.cantNodos; i++) {
			if (this.grafo.matrizAdyacencia[primero][i] == 1 && nodosVisitados[i] == 0) {
				cola.agregarAListaAlfinal(new NodoDato(i, costo+1));
				nodosVisitados[i] = 1;
			}
		}

	}

}
