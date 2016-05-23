package ordenadora;

public class Ordenadora {
	double vector[];
	int vectorInt[];

	// Constructor
	Ordenadora(double V[]) {
		vector = V;

	}

	Ordenadora(int V[]) {
		vectorInt = V;
	}

	public void seleccion() {
		int temp;
		int posicion_minimo, i, j;

		for (i = 0; i < vectorInt.length - 1; i++) {

			posicion_minimo = i;
			for (j = i + 1; j < vectorInt.length; j++)
				if (vectorInt[j] < vectorInt[posicion_minimo])
					posicion_minimo = j;

			if (posicion_minimo != i) {
				temp = vectorInt[i];
				vectorInt[i] = vectorInt[posicion_minimo];
				vectorInt[posicion_minimo] = temp;
			}

		}

	}

	public void insercion() {
		int temp;
		int i, j;

		for (i = 1; i < vectorInt.length; i++) {
			temp = vectorInt[i];

			for (j = i; (j > 0) && temp < vectorInt[j - 1]; j--) {
				vectorInt[j] = vectorInt[j - 1];
			}

			vectorInt[j] = temp;

		}

	}

	public void burbuja() {
		int i, j;
		int temp;

		for (i = 0; i < vectorInt.length; i++) {
			for (j = vectorInt.length - 1; j > i; j--) {
				if (vectorInt[j] < vectorInt[j - 1]) {
					temp = vectorInt[j];
					vectorInt[j] = vectorInt[j - 1];
					vectorInt[j - 1] = temp;
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
		//int pivote = this.vectorInt[pri];
		int medio = (pri+ult)/2;
		//int tmp;
		int izq = pri;
		int der = ult;
		
		int posMenor=elegirMenor(izq,medio,der);
		intercambiarPosicionConUltimo(posMenor);
		int pivote = this.vectorInt[der];
		der--;

		do {
			if(this.vectorInt[izq]>pivote && this.vectorInt[der]<pivote)
			{
				intercambiarPosicionesEntreSi(izq,der);
			}
			else if (this.vectorInt[izq]<=pivote)
					izq++;
				else
					der--;
			/*while (izq < der && this.vectorInt[izq] <= pivote)
				izq++;
			while (izq < der && this.vectorInt[der] > pivote)
				der--;

			if (this.vectorInt[izq] < this.vectorInt[der]) {
				tmp = this.vectorInt[izq];
				this.vectorInt[izq] = this.vectorInt[der];
				this.vectorInt[der] = tmp;
			}
			*/

		} while (izq <= der);

		/*tmp = this.vectorInt[pri];
		this.vectorInt[pri] = this.vectorInt[der];
		this.vectorInt[der] = tmp;
		*/
		intercambiarPosicionConUltimo(medio);
		return medio;
	}

	private void intercambiarPosicionesEntreSi(int izq, int der) {
		int tmp = this.vectorInt[izq];
		this.vectorInt[izq] = this.vectorInt[der];
		this.vectorInt[der] = tmp;
		
	}

	private void intercambiarPosicionConUltimo(int posMenor) {
		intercambiarPosicionesEntreSi(posMenor,this.vectorInt.length-1);
	}

	private int elegirMenor(int izq, int medio, int der) {
		if(this.vectorInt[izq]<this.vectorInt[medio]){
			if(this.vectorInt[izq]<this.vectorInt[der])
				return izq;
			return der;
		}
		if(this.vectorInt[medio]<this.vectorInt[der])
			return medio;
		return der;
	}

	public void mezcla(int desde, int elementos) {
		int Mitad;
		int ParteIzquierda;
		int ParteDerecha;
		if (elementos > 1) {

			Mitad = elementos / 2;
			ParteIzquierda = Mitad;
			ParteDerecha = elementos - Mitad;
			mezcla(0, ParteIzquierda);
			mezcla(desde + ParteIzquierda, ParteDerecha);
			ordenarMezcla(desde, ParteIzquierda, ParteDerecha);

		}

	}

	private void ordenarMezcla(int dsd, int Pizq, int Pder) {
		int i = 0;
		int j = 0;
		int k = 0;
		int[] tempvec = new int[Pizq + Pder];

		while ((i < Pizq) && (j < Pder)) {
			if (this.vectorInt[dsd + i] < this.vectorInt[dsd + Pizq + j]) {
				tempvec[k] = this.vectorInt[dsd + i];
				i++;
				k++;
			} else {
				tempvec[k] = this.vectorInt[dsd + Pizq + j];
				j++;
				k++;
			}

		}
		while (i < Pizq) {
			tempvec[k] = this.vectorInt[dsd + i];
			i++;
			k++;
		}
		while (j < Pder) {
			tempvec[k] = this.vectorInt[dsd + Pizq + j];
			j++;
			k++;
		}
		for (int l = 0; l < Pizq + Pder; l++) {
			this.vectorInt[dsd + l] = tempvec[l];

		}

	}

	public void shell() {

		int incremento = this.vectorInt.length;
		int temp = 0;
		int pivote = 0;
		do {
			incremento = incremento / 2;

			for (int i = 0; i < incremento; i++) {

				for (int j = incremento + i; j < vectorInt.length; j += incremento) {
					pivote = j;
					while ((pivote - incremento >= 0) && this.vectorInt[pivote] < this.vectorInt[pivote - incremento]) {
						temp = this.vectorInt[pivote];
						this.vectorInt[pivote] = this.vectorInt[pivote - incremento];
						this.vectorInt[pivote - incremento] = temp;
						pivote -= incremento;
					}

				}

			}

		} while (incremento > 0);
	}

}
