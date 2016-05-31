package ordenadora;

import java.io.*;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Test {

	public static int[] leerArchivo(File file) {
		int vector[] = null;
		FileReader fr = null;
		BufferedReader br;

		try {
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			String linea;

			if ((linea = br.readLine()) == null) {
				throw new Exception("Error Lectura Archivo");
			}
			int dimension = Integer.parseInt(linea);
			vector = new int[dimension];
			for (int i = 0; i < dimension; i++) {
				vector[i] = Integer.parseInt(br.readLine());
			}

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				if (null != file) {
					try {
						fr.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return vector;
	}
	
	private static void escribirArchivo(String string, int[] vector) {
		// TODO Auto-generated method stub
		FileWriter fichero = null;
		PrintWriter pw = null;

		try {
			fichero = new FileWriter(string);
			pw = new PrintWriter(fichero);
			pw.println(vector.length);
			for (int i = 0; i < vector.length; i++) {
				pw.println(vector[i]);
			}
		} catch (Exception e) {
			System.out.println("Error de Escritura Archivo de Salida - " + e.getMessage());
		} finally {
			if (null != fichero) {
				try {
					fichero.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void medirTiempoOrdenamiento(Ordenadora ord) {
		Calendar tIni;
		Calendar tFin;
		long diff;
		tIni = new GregorianCalendar();
		int modo=2;
		String modoStr;
		
		if(modo==0){
			ord.quickSort(0, ord.vector.length-1);
			modoStr="QuickSort";
		}
		else if (modo==1){
			ord.shell();
			modoStr="Shell";
		}
			else{
				ord.mezcla(0,ord.vector.length);
				//ord.burbuja();
				//ord.insercion();
				//ord.seleccion();
				modoStr="Mezcla";
			}
		tFin = new GregorianCalendar();

		diff = tFin.getTimeInMillis() - tIni.getTimeInMillis();
		System.out.println("Tiempo "+ modoStr+": " + diff);

	}

	public static void main(String[] args) {

		Ordenadora ord=null;
		
		try {
			File folder = new File("inpruebas\\");
			File[] allFiles = folder.listFiles();

			for (File file : allFiles) {
				int[] vector = leerArchivo(file);
				ord = new Ordenadora(vector);
				System.out.println(file.getName());
				medirTiempoOrdenamiento(ord);
								
				escribirArchivo("outpruebas\\"+file.getName()+".out", vector);
			}	
		} catch (Exception e){
			e.printStackTrace();
		}
			
	
	}


}
