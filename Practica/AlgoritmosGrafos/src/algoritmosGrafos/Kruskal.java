package algoritmosGrafos;

import pilaCola.ColaDinamica;

public class Kruskal extends Grafo {
	private Integer costo;
	private Integer[][] arbolAbarcadorCostoMinimo;
	 private Arista[] aristas;
	 private Integer cantidadAristas = 0;
	private Integer[] referentesNodo;

	public Kruskal(Integer cantNodos) {
		super(cantNodos);
		this.costo = 0;
		this.arbolAbarcadorCostoMinimo = new Integer[cantNodos][cantNodos];
		Integer defasaje = this.posPrimero;
		this.referentesNodo = new Integer[cantNodos];

		for (int i = 0; i < cantNodos; i++) {
			this.referentesNodo[i] = Integer.MAX_VALUE;

			for (int k = 0; k < cantNodos; k++) {
				this.arbolAbarcadorCostoMinimo[i][k] = Integer.MAX_VALUE;
			}
		}

	}

	public void obtenerArbolAbarcadorYCostoMinimo(Integer nodoInicial) {

		this.aristas = new Arista[(cantNodos) * (cantNodos - 1) / (2)];

		for (int i = 0; i < this.cantNodos; i++) {
			for (int j = i + 1; j < cantNodos; j++) {
				if (this.matrizAdyacencia[i][j] != Integer.MAX_VALUE && !cierraCicloAristaCandidata(i, j)) {
					this.aristas[cantidadAristas++]=new Arista(i+1,j+1,this.matrizAdyacencia[i][j]);
					//					this.arbolAbarcadorCostoMinimo[i][j] = this.matrizAdyacencia[i][j];
//					setearReferentesNodos(i, j);
//					costo += this.matrizAdyacencia[i][j];
				}
			}
		}
		this.ordenarAristasPorCosto();
	}

	private void ordenarAristasPorCosto() {
		for (int i = 1; i < this.cantidadAristas; i++) {
			Integer posInicio=i;
			Integer posMenor=i-1;
			Integer menor = this.aristas[posMenor].valorAgrupador;
			for (int j = posInicio; j < cantidadAristas; j++) {
				if(this.aristas[j]<this.aristas[posMenor])
					
			}
			
		}
		
	}

	public void setearReferentesNodos(int i, int j) {

		if (this.referentesNodo[i] == Integer.MAX_VALUE || this.referentesNodo[j] == Integer.MAX_VALUE)
			this.referentesNodo[i] = Math.max(i + 1, j + 1);
		else {
			Integer viejoValor = Math.min(this.referentesNodo[i], this.referentesNodo[j]);
			Integer nuevoValor = Math.max(this.referentesNodo[i], this.referentesNodo[j]);

			if (this.referentesNodo[i] == viejoValor) {
				this.referentesNodo[i] = nuevoValor;
			} else {
				this.referentesNodo[j] = nuevoValor;
			}
			reemplazarNuevoValorPorViejo(nuevoValor, viejoValor);

		}

	}

	public void reemplazarNuevoValorPorViejo(Integer nuevoValor, Integer viejoValor) {
		for (int i = 0; i < this.referentesNodo.length; i++) {
			if (this.referentesNodo[i] == viejoValor)
				this.referentesNodo[i] = nuevoValor;
		}

	}

	// public Integer referentesVecinos(Integer mayor) {
	// Integer retornar=mayor;
	// for (int i = 0; i < this.arbolAbarcadorCostoMinimo.length; i++) {
	// if(this.arbolAbarcadorCostoMinimo[mayor-1][i]!=Integer.MAX_VALUE&&i>mayor-1)
	// mayor=i+1;
	// }
	// return null;
	// }

	public boolean cierraCicloAristaCandidata(int i, int j) {
		if (this.referentesNodo[i] != this.referentesNodo[j])
			return false;
		return true;
	}
}
