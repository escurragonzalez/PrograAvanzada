package ecuacionesLineales;

import java.util.Scanner;

public class Test {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		String modo ;
		System.out.println("***INGRESE MODO DE OPERACION***");
		System.out.println("(0:RESOLUCION - 1:PROBADOR)");
               
		do {
			Scanner entradaEscaner = new Scanner (System.in);
			
			modo = entradaEscaner.nextLine ();
			
			} while (!modo.equals("1") && !modo.equals("0"));
		
		if (modo.equals("1")) {
			System.out.println("***PROGRAMA PROBADOR***");
			
			Probador probador = new Probador();
		
			System.out.println("EL OUTPUT ES CORRECTO: " + probador.probarSel());
		}
		else{
			Sel prueba = new Sel();
			
			System.out.println("***RESOLUCION SISTEMAS DE ECUACIONES***");
			
			System.out.println("SIN RESOLVER:");
			System.out.println(prueba.toString());
			
			prueba.resolver();
			
			System.out.println("RESUELTO:");
			System.out.println(prueba.toString());
			
		}
		
	}

}
