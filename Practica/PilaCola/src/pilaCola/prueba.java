package pilaCola;

public class prueba {

	public static void main(String[] args) {
		
		 pilaCL pila;
		 NodoDato dato1 = new NodoDato(3);
		 NodoDato dato2 = new NodoDato(11);
		 NodoDato dato3 = new NodoDato(121);
		pila = new pilaCL();
		pila.apilar(dato1);
		pila.apilar(dato2);
		pila.apilar(dato3);
		
	}

}
