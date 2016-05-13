package pilaCola;

public class pilaCL implements pila{
	private Lista pila;

	
	public pilaCL(){
		pila = new Lista();
	}
	
	@Override
	public void apilar(NodoDato dato) {
		this.pila.agregarALista(dato);
		
	}

	@Override
	public NodoDato desapilar() {
		return this.pila.sacarDeLista();
		
	}

	@Override
	public boolean estaVacia() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void vaciar() {
		// TODO Auto-generated method stub
		
	}

}
