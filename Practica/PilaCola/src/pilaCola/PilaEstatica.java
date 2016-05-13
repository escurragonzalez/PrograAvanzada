package pilaCola;

public class PilaEstatica implements pila { // Implementa la interfaz definida.

	private NodoDato V[];
	int tamanio, tope;

	// La interfaz nos servira para definir el comportamiento. Por ejemplo, si
	// no la tuviera y la pila hereda todo
	// entonces podremos dar vuelta una pila..y no deberíamos. Con la interfaz
	// evitamos esto.

	public PilaEstatica() {
		this.tamanio = 1;
		this.tope = -1;
		this.V = new NodoDato[this.tamanio];
	}

	public void apilar(NodoDato dato) {
		if (this.tamanio == this.tope + 1) {
			this.resize();
		}

		tope++;
		this.V[tope] = dato;

	}

	public NodoDato desapilar() {
		if (this.tope == -1)
			return null;
		NodoDato retorno = this.V[tope];
		tope--;
		return retorno;

	}

	public boolean estaVacia() {
		if (this.tope == -1)
			return true;
		return false;
	}

	public void vaciar() {
		this.tope = -1;
		this.tamanio = 1;
		this.V = new NodoDato[this.tamanio];
	}

	public void resize() {
		NodoDato[] vecN = new NodoDato[this.tamanio * 2];
		for (int i = 0; i < this.tamanio; i++)
			vecN[i] = this.V[i];
		this.V = vecN;
	}

}