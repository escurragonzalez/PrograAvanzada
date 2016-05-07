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

	public void QuickSort(int izq, int der) {

		int pivote;

		if (izq < der) {
			pivote = Partir(izq, der);
			QuickSort(izq, pivote - 1);
			QuickSort(pivote + 1, der);
		}
	}

	private int Partir(int pri, int ult) {
		int pivote = this.vector[pri];
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

	public void Mezcla(int desde, int elementos) {
		int Mitad;
		int ParteIzquierda;
		int ParteDerecha;
		if (elementos > 1) {

			Mitad = elementos / 2;
			ParteIzquierda = Mitad;
			ParteDerecha = elementos - Mitad;
			Mezcla(0, ParteIzquierda);
			Mezcla(desde + ParteIzquierda, ParteDerecha);
			OrdenaMezcla(desde, ParteIzquierda, ParteDerecha);

		}

	}

	private void OrdenaMezcla(int dsd, int Pizq, int Pder) {
		int i = 0;
		int j = 0;
		int k = 0;
		int[] tempvec = new int[Pizq + Pder];

		while ((i < Pizq) && (j < Pder)) {
			if (this.vector[dsd + i] < this.vector[dsd + Pizq + j]) {
				tempvec[k] = this.vector[dsd + i];
				i++;
				k++;
			} else {
				tempvec[k] = this.vector[dsd + Pizq + j];
				j++;
				k++;
			}

		}
		while (i < Pizq) {
			tempvec[k] = this.vector[dsd + i];
			i++;
			k++;
		}
		while (j < Pder) {
			tempvec[k] = this.vector[dsd + Pizq + j];
			j++;
			k++;
		}
		for (int l = 0; l < Pizq + Pder; l++) {
			this.vector[dsd + l] = tempvec[l];

		}

	}

	public void Shell() {

		int incremento = this.vector.length;
		int temp = 0;
		int pivote = 0;
		do {
			incremento = incremento / 2;

			for (int i = 0; i < incremento; i++) {
				for (int j = 0 + i; j < vector.length; j += incremento) {
					pivote = j;
					while ((j + incremento < this.vector.length) && this.vector[pivote] > this.vector[j + incremento]) {
						temp = this.vector[pivote];
						this.vector[pivote] = this.vector[j + incremento];
						this.vector[j + incremento] = temp;
						pivote += incremento;
					}

				}

			}

		} while (incremento > 1);
	}
}
