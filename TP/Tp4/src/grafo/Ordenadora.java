package grafo;

public class Ordenadora {
	Arista vector[];

	// Constructor
	Ordenadora(Arista V[]) {
		//vector = new int[V.length];
		vector = V;

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
		Arista pivote = this.vector[(pri+ult)/2];
		
		Arista aux = this.vector[pri];
		this.vector[pri]=pivote;
		this.vector[(pri+ult)/2]=aux;
		
		Arista tmp;
		int izq = pri + 1;
		int der = ult;

		do {

			while (izq <= der && this.vector[izq].valorRandom <= pivote.valorRandom)
				izq++;
			while (izq <= der && this.vector[der].valorRandom > pivote.valorRandom)
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

	

		
}
