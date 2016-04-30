package clase1Taller;

public class Prueba {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Punto centro1=new Punto (1,1);
		Punto centro2=new Punto (2,2);
		Punto centro3=new Punto (10,10);
		Punto punto1=new Punto (10,10);
		Punto punto2=new Punto (1,2);
		Circulo circulo1=new Circulo (centro1,4);
		Circulo circulo2=new Circulo (centro2,4);
		Circulo circulo3=new Circulo (centro3,3);
		
		System.out.println("Radio del circulo: " + circulo1.getRadio());
		
		System.out.println(" * El Circulo1 contiene al punto1: " + circulo1.contiene(punto1));
		System.out.println(" * El Circulo1 contiene al punto2: " + circulo1.contiene(punto2));
		
		System.out.println(" * El Circulo1 intersecta al circulo2: " + circulo1.intersectaCon(circulo2));
		System.out.println(" * El Circulo1 intersecta al circulo3: " + circulo1.intersectaCon(circulo3));
		
		//-----------
		
		Punto referencia1=new Punto(7,7);
		Rectangulo rectangulo1=new Rectangulo(10,5,referencia1);
		
		System.out.println("***Area del rectangulo: " + rectangulo1.getArea());
		
		
	}

}
