package ecuacionesLineales;

public class Test {

	public static void main(String[] args) {
		
		Sel prueba = new Sel();
		
		System.out.println("***PROGRAMA RESOLUCION SISTEMAS DE ECUACIONES***");
		
		System.out.println("SIN RESOLVER:");
		System.out.println(prueba.toString());
		
		prueba.resolver();
		
		System.out.println("RESUELTO:");
		System.out.println(prueba.toString());
		
		//Probador prueba = new Probador();
	
		//System.out.println("EL OUTPUT ES CORRECTO: " + prueba.probarSel());
		
	}

}
