package pilaCola;

public class ColaDinamica extends Lista{
	//refUltimoNodo;
	//implementar en lista
	//encolar
	//desencolar
	//ponerFinal
	//sacarFinal
	
	public ColaDinamica() {

		super(); // Llama al constructor del que hereda

	}

	public void encolar(NodoDato dato) {

		this.agregarAListaAlfinal(dato);

	}

	public NodoDato desencolar() {
		return this.sacarDeLista();
	}

	public boolean estaVacia() {
		return super.estaVacia();
	}

	public void vaciar() {
		this.vaciar();
	}
	
	public NodoDato obtenerUltimo(){
		return this.nodoUltimo.valor;
	}
	
	public NodoDato obtenerPrimero(){
		return this.nodo.valor;
	}
}

/*
4 casos:
imp:interfaz pila
pilaCL
pilaHL

imp:interfaz cola
colaCL
colaHL
*/