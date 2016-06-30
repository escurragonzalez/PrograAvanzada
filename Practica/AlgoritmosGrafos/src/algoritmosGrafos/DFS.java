package algoritmosGrafos;

import pilaCola.NodoDato;
import pilaCola.pilaCL;


public class DFS extends Grafo {
	private Boolean[] Visitados;
	private pilaCL pilaTemp;

	public DFS(Integer cantNodos) {
		super(cantNodos);
		this.Visitados = new Boolean[cantNodos];
		for (int i = 0; i < cantNodos; i++) {
			this.Visitados[i] = new Boolean(false);
		}
		this.pilaTemp = new pilaCL();

	}

	public void recorrerTodosNodosAPartirDeRaiz(Integer raiz) {

		this.pilaTemp.apilar(new NodoDato(raiz));// guarda el valor del nodo en
													// la pila
		this.Visitados[raiz] = true;

		
		
		for (int i = 0; i < this.cantNodos; i++) {
			if (this.matrizAdyacencia[raiz][i] != Integer.MAX_VALUE && this.Visitados[i] == false) {
				this.recorrerTodosNodosAPartirDeRaiz(i);
			}
		}

		if (this.pilaTemp.estaVacia() == false) {
			this.tratarNodo(this.pilaTemp.desapilar().getValor());
		}
	}

	private void tratarNodo(int i) {
		System.out.println("Hola, soy el nodo:" + i);

	}

	public Boolean[] getVisitados() {
		return Visitados;
	}

	public void setVisitados(Boolean[] visitados) {
		Visitados = visitados;
	}

	public pilaCL getPilaTemp() {
		return pilaTemp;
	}

	public void setPilaTemp(pilaCL pilaTemp) {
		this.pilaTemp = pilaTemp;
	}
	
}
