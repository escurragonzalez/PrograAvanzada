package tp3;

public class PilaDinamica extends Lista implements Pila{ // Implementa la interfaz definida.

	public PilaDinamica() {
		super(); // Llama al constructor del que hereda
	}

	public void apilar(NodoDato dato) {

		this.agregarALista(dato);

	}

	public NodoDato desapilar() {
		return this.sacarDeLista();
	}

	public boolean estaVacia() {
		return this.estaVacia();
	}

	public void vaciar() {
		this.vaciar();
	} 
	
	public void agregarAListaAlfinal(NodoDato dato){
	
	}
}