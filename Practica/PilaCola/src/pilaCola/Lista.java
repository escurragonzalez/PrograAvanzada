package pilaCola;





public class Lista {
	protected NodoLista nodo;
	
	public Lista() {
		
		this.nodo=null;
			
	}

	public void agregarALista(NodoDato dato) {
		if(this.nodo == null)
		{
			this.nodo = new NodoLista();
			this.nodo.valor = dato;
			this.nodo.siguiente = null;
		}
		else{
			NodoLista aux = new NodoLista();
			aux.siguiente = this.nodo;
			aux.valor = dato;
			this.nodo = aux;
		}
		
		
	}

	public NodoDato sacarDeLista() {
		if (this.nodo == null)
			return null;
		NodoDato retorno = this.nodo.valor;
		this.nodo = this.nodo.siguiente;
		return retorno;

	}

	public boolean estaVacia() {
		if (this.nodo == null)
			return true;
		return false;
		
	}

	public void vaciar() {
		this.nodo = null;
		}
	
	
	
	
	
}

