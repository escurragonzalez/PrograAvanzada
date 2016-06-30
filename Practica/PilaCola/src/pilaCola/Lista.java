package pilaCola;





public class Lista {
	protected NodoLista nodo;
	protected NodoLista nodoUltimo;
	
	public Lista() {
		
		this.nodo=null;
		this.nodoUltimo=null;
			
	}

	public void agregarALista(NodoDato dato) {
		if(this.nodo == null)
		{
			this.nodo = new NodoLista();
			this.nodo.valor = dato;
			this.nodo.siguiente = null;
			this.nodoUltimo = this.nodo;
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
		if(this.nodo != null && this.nodo.siguiente==null)//Si la lista quedo con un solo elemento
			this.nodoUltimo=this.nodo;
		return retorno;

	}

	public boolean estaVacia() {
		if (this.nodo == null)
			return true;
		return false;
		
	}

	public void vaciar() {
		this.nodo = null;
		this.nodoUltimo = null;
		}
	
	
	//Primitivas que nos ayudaran a implementar Cola Dinamica
	
	public void agregarAListaAlfinal(NodoDato dato) {
		if(this.nodoUltimo == null)
		{
			this.nodo = new NodoLista();
			this.nodo.valor = dato;
			this.nodo.siguiente = null;
			this.nodoUltimo = this.nodo;
		}
		else{
			NodoLista aux = new NodoLista();
			aux.siguiente = null;
			aux.valor = dato;
			this.nodoUltimo.siguiente = aux;
			this.nodoUltimo = aux;
		}
		
		
	}

	
	//END Primitivas que nos ayudaran a implementar Cola Dinamica
	
	
}

