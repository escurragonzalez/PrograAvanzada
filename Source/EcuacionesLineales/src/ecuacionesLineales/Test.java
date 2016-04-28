package ecuacionesLineales;

import java.util.Scanner;

public class Test {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		String folderArchIn="..\\..\\Preparacion De La Prueba\\Lote De Prueba\\Casos De Prueba\\Sel\\IN-Esperado\\";
		//String folderArchIn="F:\\UNLAM\\PrograAvanzada\\TPS\\TP2\\PrograAvanzada-master_1er_entrega - Correccion\\Preparacion De La Prueba\\Lote De Prueba\\Casos De Prueba\\Sel\\IN-Esperado\\";
		String pathArchIn = folderArchIn+"10_10x10Normal.in" ;
		String pathArchOut = "outpruebas\\solucion10.out";
		
		String modo ;
		System.out.println("***INGRESE MODO DE OPERACION***");
		System.out.println("(0:RESOLUCION - 1:PROBADOR)");
               
		do {
			Scanner entradaEscaner = new Scanner (System.in);
			
			modo = entradaEscaner.nextLine ();
			
			} while (!modo.equals("1") && !modo.equals("0"));
		
		if (modo.equals("1")) {
			System.out.println("***PROGRAMA PROBADOR***");
			
			Probador probador = new Probador(pathArchIn,pathArchOut);
		
			System.out.println("EL OUTPUT ES CORRECTO: " + probador.probarSel());
		}
		else{
		    Sel prueba = new Sel(pathArchIn);
			
		    if (prueba.tieneAtributosIncompletos()) {
				System.out.println("Error - El programa se cerrara");
				return;
			}
		    		
			System.out.println("***RESOLUCION SISTEMAS DE ECUACIONES***");
			
			System.out.println("SIN RESOLVER:");
			System.out.println(prueba.toString());
			
			prueba.resolver(pathArchOut);
			
			System.out.println("RESUELTO:");
			System.out.println(prueba.toString());
			
		}
		
	}

}
