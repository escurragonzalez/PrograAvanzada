package tp3;

public class Expresion implements IOperacion{

	private PilaDinamica pila;
	
	public Expresion(String linea){
		pila = new PilaDinamica();
		String[] splitline=null;
		NodoDato nodo= null;
		NodoDato nodo2 = null;
		NodoDato op=null;
		splitline= linea.split(" ");
		for (int i = 0; i < splitline.length; i++) {
			switch(splitline[i]){
			case "x":
				nodo=new NodoDato(VariableX.getInstance());
				pila.apilar(nodo);
				break;
			case "y":
				nodo=new NodoDato(VariableY.getInstance());
				pila.apilar(nodo);
				break;
			case "z":
				nodo=new NodoDato(VariableZ.getInstance());
				pila.apilar(nodo);
				break;
			case "*":
				nodo = pila.desapilar();
				nodo2= pila.desapilar();
				Producto p = new Producto(nodo.getTermino(),nodo2.getTermino());
				op= new NodoDato(p);
				pila.apilar(op);
				break;
			case "+":
				nodo = pila.desapilar();
				nodo2= pila.desapilar();
				Suma s = new Suma(nodo.getTermino(),nodo2.getTermino());
				op= new NodoDato(s);
				pila.apilar(op);
				break;
			case "-":
				nodo = pila.desapilar();
				nodo2= pila.desapilar();
				Resta r = new Resta(nodo.getTermino(),nodo2.getTermino());
				op = new NodoDato(r);
				pila.apilar(op);
				break;
			case "/":
				nodo = pila.desapilar();
				nodo2= pila.desapilar();
				Cociente c = new Cociente(nodo.getTermino(),nodo2.getTermino());
				op= new NodoDato(c);
				pila.apilar(op);
				break;
			case "^":
				nodo = pila.desapilar();
				nodo2= pila.desapilar();
				Potencia po = new Potencia(nodo.getTermino(),nodo2.getTermino());
				op= new NodoDato(po);
				pila.apilar(op);
				break;
			case "ln":
				nodo = pila.desapilar();
				Logaritmo l = new Logaritmo(nodo.getTermino());
				op= new NodoDato(l);
				pila.apilar(op);
				break;
			default:
				Constante constante= new Constante(Double.parseDouble(splitline[i]));
				NodoDato  nodoC=new NodoDato(constante);
				pila.apilar(nodoC);
				break;
			}
		}
	}
	
	@Override
	public double resolver() {
		Constante constante= new Constante(2);
		NodoDato nodo= new NodoDato(constante);
		double r=0;
		nodo=pila.desapilar();
		r=nodo.getTermino().resolver();
		pila.apilar(nodo);
		return r;
	}
	

}
