package ar.unlam.gcf;

import java.io.FileWriter;
import java.io.PrintWriter;

public class GeneradorSencillo {

private String cantidadNodos="3445";
private String pathArchivo = cantidadNodos+"esquinasx"+cantidadNodos+"calles";

	public static void main(String[] args) {
		GeneradorSencillo objeto=new GeneradorSencillo();
		objeto.escribirArchivo("PRUEBA\\" + objeto.pathArchivo + ".in");

	}
	
	//Escritura del archivo
		public void escribirArchivo(String ruta){//este generador crea dos rutas alternativas(calles pares y calles impares)
												 //de manera tal que se debe cambiar el sentido de la calle 1 para lograr el 
												 //camino optimo
			
			FileWriter fw = null;
			PrintWriter pw = null;

			try {

				fw = new FileWriter(ruta);
				pw = new PrintWriter(fw);
					
					pw.println(cantidadNodos+" 1 "+cantidadNodos);					
					
					Integer cantidadNodosInt=Integer.parseInt(cantidadNodos);
					
					pw.println(cantidadNodos);
					
					pw.println("2 1 2");					
					
					for (int i = 1; i < cantidadNodosInt/2 ; i++) {
						pw.println(2*i+" "+2*(i+1)+" 2");
						pw.println(((2*i)-1)+" "+((2*(i+1))-1)+" 3");						
					}
					
					if(cantidadNodosInt%2!=0)
						pw.println((cantidadNodosInt-2)+" "+cantidadNodosInt+" 3");
					
					pw.println((cantidadNodosInt-1)+" "+cantidadNodosInt+" 2");
				

			} catch (Exception e1) {
				System.out.println("Error de Escritura Archivo de Salida - " + e1.getMessage());
			} finally {
				if (ruta != null) {
					try {
						fw.close();
					} catch (Exception e2) {
						e2.printStackTrace();
					}
				}

			}

		}
}
