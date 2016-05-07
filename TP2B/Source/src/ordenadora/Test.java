package ordenadora;
import java.io.*;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Test {

	public static void main(String[] args) {
		
		
		File archivo;
		FileReader fr;
		BufferedReader br;

	try {
		archivo = new File("..\\Preparacion de la Prueba\\Casos De Prueba\\Ordenadora\\IN-Esperado\\10_Vector350000ElementosAleatorio.in");
		fr = new FileReader(archivo);
		br = new BufferedReader(fr);
		
		String linea;
		
		if((linea = br.readLine())==null){
			throw new Exception ("Error Lectura Archivo");
		}
		
		int dimension = Integer.parseInt(linea);
		int vector[] = new int[dimension];
		
		for (int i = 0; i < dimension; i++) {
			vector[i]=Integer.parseInt(br.readLine());
		}
		
		



		

		
		
		
		Ordenadora vec;
	
		vec = new Ordenadora (vector);
		Calendar tIni;
		Calendar tFin;
		long diff;
		
//		tIni = new GregorianCalendar();
//		
//		vec.Seleccion();
//		tFin = new GregorianCalendar();
//		
//		diff = tFin.getTimeInMillis() - tIni.getTimeInMillis();
//		System.out.println("Tiempo Seleccion: "+diff);
/////////////////////////////////////////		
//		 tIni = new GregorianCalendar();
//	
//		vec.Shell();
//		tFin = new GregorianCalendar();
//		
//		diff = tFin.getTimeInMillis() - tIni.getTimeInMillis();
//		System.out.println("Tiempo Shell: "+diff);
/////////////////////////////////////////		
//		 tIni = new GregorianCalendar();
//			
//			vec.Insercion();
//			tFin = new GregorianCalendar();
//			
//			diff = tFin.getTimeInMillis() - tIni.getTimeInMillis();
//			System.out.println("Tiempo Insercion: "+diff);
/////////////////////////////////////////		
		 tIni = new GregorianCalendar();
			
			vec.Burbuja();
			tFin = new GregorianCalendar();
			
			diff = tFin.getTimeInMillis() - tIni.getTimeInMillis();
			System.out.println("Tiempo Burbuja: "+diff);
/////////////////////////////////////////
		
//			tIni = new GregorianCalendar();
//			vec.Mezcla(0,vec.vector.length-1);
//			tFin = new GregorianCalendar();
//			
//			diff = tFin.getTimeInMillis() - tIni.getTimeInMillis();
//			System.out.println("Tiempo Mezcla: "+diff);
/////////////////////////////////////////			
//			tIni = new GregorianCalendar();
//			vec.QuickSort(0, (vec.vector.length-1));
//			tFin = new GregorianCalendar();
//			
//			diff = tFin.getTimeInMillis() - tIni.getTimeInMillis();
//			System.out.println("Tiempo Quick Sort: "+diff);
///////////////////////////////////////////
			
			
			
		FileWriter fichero = null;
		PrintWriter pw = null;
		
		try {
			fichero = new FileWriter("outpruebas\\10_Vector350000ElementosAleatorio.out");
			pw = new PrintWriter(fichero);
			pw.println(vec.vector.length);
			for (int i = 0; i < vec.vector.length; i++) {
				pw.println(vec.vector[i]);
			}
		} catch (Exception e) {
			System.out.println("Error de Escritura Archivo de Salida - "+e.getMessage());
		} finally {
			if (null != fichero) {
				try {
					fichero.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		
		
		
		System.out.println("hola");
		
				
	} catch (Exception e) {
		e.printStackTrace();
	}
		
		

	}

}
