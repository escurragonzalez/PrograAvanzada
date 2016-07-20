package ordenadora;

public class Ordenadora {
	int vector[];

	// Constructor
	Ordenadora(int V[]) {
		vector = new int[V.length];
		vector = V;

	}

	public void Seleccion() {
		int temp;
		int posicion_minimo, i, j;

		for (i = 0; i < vector.length - 1; i++) {

			posicion_minimo = i;
			for (j = i + 1; j < vector.length; j++)
				if (vector[j] < vector[posicion_minimo])
					posicion_minimo = j;

			if (posicion_minimo != i) {
				temp = vector[i];
				vector[i] = vector[posicion_minimo];
				vector[posicion_minimo] = temp;
			}

		}

	}

	public void Insercion() {
		int temp;
		int i, j;

		for (i = 1; i < vector.length; i++) {
			temp = vector[i];

			for (j = i; (j > 0) && temp < vector[j - 1]; j--) {
				vector[j] = vector[j - 1];
			}

			vector[j] = temp;

		}

	}

	public void Burbuja() {
		int i, j;
		int temp;

		for (i = 0; i < vector.length; i++) {
			for (j = vector.length - 1; j > i; j--) {
				if (vector[j] < vector[j - 1]) {
					temp = vector[j];
					vector[j] = vector[j - 1];
					vector[j - 1] = temp;
				}

			}
		}

	}

	public void quickSort(int izq, int der) {

		int pivote;

		if (izq < der) {
			pivote = partir(izq, der);
			quickSort(izq, pivote - 1);
			quickSort(pivote + 1, der);
		}
	}

	private int partir(int pri, int ult) {
		int pivote = this.vector[(pri+ult)/2];
		
		int aux = this.vector[pri];
		this.vector[pri]=pivote;
		this.vector[(pri+ult)/2]=aux;
		
		int tmp;
		int izq = pri + 1;
		int der = ult;

		do {

			while (izq <= der && this.vector[izq] <= pivote)
				izq++;
			while (izq <= der && this.vector[der] > pivote)
				der--;

			if (izq <= der) {
				tmp = this.vector[izq];
				this.vector[izq] = this.vector[der];
				this.vector[der] = tmp;
			}

		} while (izq <= der);

		tmp = this.vector[pri];
		this.vector[pri] = this.vector[der];
		this.vector[der] = tmp;

		return der;
	}

		public void mezcla(int comienzoVector, int cantElem) {
			int parteIzquierda;
			int parteDerecha;
			if (cantElem > 1) {
	
				parteIzquierda = cantElem/2;
				parteDerecha = cantElem - parteIzquierda;
				mezcla(comienzoVector, parteIzquierda);
				mezcla(comienzoVector + parteIzquierda, parteDerecha);
				ordenarMezcla(comienzoVector, parteIzquierda, parteDerecha);
	
			}
	
		}
	
		private void ordenarMezcla(int dsd, int pIzq, int pDer) {
			int i = 0;
			int j = 0;
			int k = 0;
			int[] tempvec = new int[pIzq + pDer];
	
			while ((i < pIzq) && (j < pDer)) {
				if (this.vector[dsd + i] < this.vector[dsd + pIzq + j]) {
					tempvec[k] = this.vector[dsd + i];
					i++;
					k++;
				} else {
					tempvec[k] = this.vector[dsd + pIzq + j];
					j++;
					k++;
				}
	
			}
			while (i < pIzq) {
				tempvec[k] = this.vector[dsd + i];
				i++;
				k++;
			}
			while (j < pDer) {
				tempvec[k] = this.vector[dsd + pIzq + j];
				j++;
				k++;
			}
			for (int l = 0; l < pIzq + pDer; l++) {
				this.vector[dsd + l] = tempvec[l];
	
			}
	
		}
	public void shell() {
	
			int incremento = this.vector.length;
			int temp = 0;
			int pivote = 0;
			do {
				incremento = incremento / 2;
	
				for (int i = 0; i < incremento; i++) {
	
					for (int j = incremento + i; j < vector.length; j += incremento) {
						pivote = j;
						while ((pivote - incremento >= 0) && this.vector[pivote] < this.vector[pivote - incremento]) {
							temp = this.vector[pivote];
							this.vector[pivote] = this.vector[pivote - incremento];
							this.vector[pivote - incremento] = temp;
							pivote -= incremento;
						}
	
					}
	
				}
	
			} while (incremento > 0);
		}


		
}
