package algoritmosGrafos;

import pilaCola.ColaDinamica;
import pilaCola.NodoDato;;

public class BFS extends Grafo {
	private Boolean[] Visitados;
	private ColaDinamica colaTemp;

	public BFS(Integer cantNodos) {
		super(cantNodos);
		this.Visitados = new Boolean[cantNodos];
		for (int i = 0; i < cantNodos; i++) {
			this.Visitados[i] = new Boolean(false);
		}
		this.colaTemp = new ColaDinamica();

	}

	public void recorrerTodosNodosAPartirDeRaiz(Integer raiz) {

		this.colaTemp.encolar(new NodoDato(raiz));// guarda el valor del nodo en
													// la cola
		this.Visitados[raiz] = true;

		while (!colaTemp.estaVacia()) {
			NodoDato primero = colaTemp.desencolar();

			// BEGIN TRATAR PRIMERO

			System.out.println("Hola soy el nodo:" + primero.getValor());

			// END TRATAR PRIMERO

			encolarHijos(primero.getValor());

		}
	}

	private void encolarHijos(Integer valor) {
		Integer defasaje=this.posPrimero;
		for (int i = 0; i < matrizAdyacencia.length; i++) {
			if(this.matrizAdyacencia[valor-defasaje][i-defasaje]!=Integer.MAX_VALUE&&this.Visitados[i-defasaje]==false){
				this.colaTemp.encolar(new NodoDato(i+defasaje));
				this.Visitados[i-defasaje] = true;
			}
		}

	}
}
