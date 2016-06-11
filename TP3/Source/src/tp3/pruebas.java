package tp3;


public class pruebas {

	public static void main(String[] args) {
		ArmarUnaExpresion();
	}

	public static void ArmarUnaExpresion() {	
		String linea="2 3 -";
		Expresion ex=new Expresion(linea);
		System.out.println(ex.resolver());
	}

}
