
import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class GeneradorCasosPrueba {

	//private MatrizMath matrizCoeficientes;
	//private VectorMathInt vectorTerminosIndependientes;
	
	public GeneradorCasosPrueba(){
		
	}
	
	/*public GeneradorCasosPrueba(int dimension){
		//this.matrizCoeficientes=new MatrizMath(dimension,dimension);
		this.vectorTerminosIndependientes = new VectorMathInt(dimension);
	}*/
	
	private int generarNumeroRandom(){
		
		int numeroRandom;
		Random randomGenerator = new Random();
		//int randomInt = randomGenerator.nextInt(1000000);
	    //int randomDouble = randomGenerator.nextInt();
		numeroRandom=randomGenerator.nextInt(60);
		
		numeroRandom+=20;
		return numeroRandom;
	}
	
	private char generarSexoRandom(){
		
		char charRandom='F';
		int numeroRandom;
		Random randomGenerator = new Random();
		//int randomInt = randomGenerator.nextInt(1000000);
	    //int randomDouble = randomGenerator.nextInt();
		numeroRandom=randomGenerator.nextInt(2);
		
		if(numeroRandom == 1)
			charRandom = 'M';
		
		return charRandom;
	}
	
	/*private void generarMatrizRandom(){
		int dimension=this.matrizCoeficientes.getDimensionCol();
		double[][] componentes = new double[dimension][dimension];
		
		for (int i=0; i<dimension; i++)
			for (int j=0; j<dimension; j++)
				componentes[i][j]=this.generarNumeroRandom();
		
		this.matrizCoeficientes.setComponentes(componentes);
	}*/
	
	/*private void generarVectorRandom(){
		
		int dimension=this.vectorTerminosIndependientes.getDimension();
		long[] componentes = new long[dimension];
		
	    for(int i = 0; i < dimension; i++)
	    	componentes[i]=this.generarNumeroRandom();
		     
		this.vectorTerminosIndependientes.setComponentes(componentes);
	}*/
	
	public void escribirArchivoSalida(String archOut){
		FileWriter archivo = null;
		PrintWriter pw = null;
		
		try {
			archivo = new FileWriter(archOut);
			pw = new PrintWriter(archivo);
			
			//pw.println(this.vectorTerminosIndependientes.getDimension());
			for(int i=1; i<1000001; i++){
					//for(int j=0; j<this.matrizCoeficientes.getDimensionCol(); j++)
				int numeroAPoner;
				if(i%2 == 0)
					numeroAPoner=i;
				else
					numeroAPoner=1000000-i;
				pw.println(numeroAPoner);// + " "+ this.matrizCoeficientes.getComponentes()[i][j]);
			//for(int k=0; k<this.vectorTerminosIndependientes.getDimension(); k++)
			//	pw.println(this.vectorTerminosIndependientes.getComponentes()[k]);
			}
			
		} catch (Exception e) {
			System.out.println("Error de Escritura Archivo de Salida - "+e.getMessage());
		} finally {
			if (null != archivo) {
				try {
					archivo.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	
	public static void main(String[] args) {
		
		String folderArchIn="inpruebas\\";
		//String folderArchIn="F:\\UNLAM\\PrograAvanzada\\TPS\\TP2\\PrograAvanzada-master_1er_entrega - Correccion\\Preparacion De La Prueba\\Lote De Prueba\\Casos De Prueba\\Sel\\IN-Esperado\\";
		String pathArchIn ;
				
	    String modo;
		System.out.println("***DESEA GENERAR UN ARCHIVO DE PRUEBA?:***");
		System.out.println("(S: generar /N: salir)");
		Scanner entradaEscaner = new Scanner (System.in);  
		do {
			
			modo = entradaEscaner.nextLine ();
			
			} while (!modo.equals("s") && !modo.equals("S") && !modo.equals("si") && !modo.equals("Si") && !modo.equals("n") && !modo.equals("N") && !modo.equals("no") && !modo.equals("No"));
		
		
		
		if (modo.equals("s")||modo.equals("S")||modo.equals("si")||modo.equals("Si")) {
			
			Scanner entradaDimension = new Scanner (System.in);
			
			String dim;
					
			System.out.println("***GENERADOR DE CASOS DE PRUEBA***");
			System.out.println("***INGRESE EL TAMAÑO DEL SEL***");
			dim=entradaDimension.nextLine ();
			
			GeneradorCasosPrueba testCase = new GeneradorCasosPrueba();
			pathArchIn = folderArchIn+"prueba.in" ;
		    testCase.escribirArchivoSalida(pathArchIn);
			//testCase.generarMatrizRandom();
		    //testCase.generarVectorRandom();
			/*for (int cantidadElementos = 10000; cantidadElementos < 20000 ; cantidadElementos+=10000) {
				
				//GeneradorCasosPrueba testCase = new GeneradorCasosPrueba(cantidadElementos);
				pathArchIn = folderArchIn+"Vector"+cantidadElementos+"elementosDesordenado.in" ;
			    //testCase.generarVectorDecreciente();
			    //testCase.escribirArchivoSalida(pathArchIn);
			}*/
			System.out.println("ARCHIVO GENERADO");
			entradaDimension.close();
		}
		else{
				System.out.println("El programa se cerrara");
			}
		    		
		entradaEscaner.close();
		}

	/*private void generarVectorCreciente() {
		int dimension=this.vectorTerminosIndependientes.getDimension();
		long[] componentes = new long[dimension];
		
	    for(int i = 0; i < dimension; i++)
	    	componentes[i]= i * (1000000 /this.vectorTerminosIndependientes.getDimension());
		     
		this.vectorTerminosIndependientes.setComponentes(componentes);
	}
	
	private void generarVectorDecreciente() {
		int dimension=this.vectorTerminosIndependientes.getDimension();
		long[] componentes = new long[dimension];
		
	    for(int i = 0; i < dimension; i++)
	    	componentes[i]= 999995 - (i * (1000000 /this.vectorTerminosIndependientes.getDimension()));
		     
		this.vectorTerminosIndependientes.setComponentes(componentes);
	}
	*/

}

