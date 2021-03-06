package ecuacionesLineales;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Probador {
	
	private MatrizMath matrizCoeficientes; //INPUT
	private VectorMath vectorTerminosIndependientes;//INPUT
	private VectorMath vectorIncognita; //OUTPUT
	private double errorSel; //OUTPUT
	//public final String PATH_ARCH_IN = "sel.in";
	//public final String PATH_ARCH_OUT = "solucion.out";
	
	public Probador(String archIn,String archOut){
		//ARCHIVO IN
		File archivo=null;
		FileReader fr=null;
		BufferedReader br = null;
		String linea="";
		String[] arraySplit;
		double[][] matriz = null;
		Integer orden=0;
		double[] vector = null;
		try {
			//ABRO ARCHIVO:
			archivo= new File("archIn");
			fr=new FileReader(archivo);
			br=new BufferedReader(fr);
			//CARGO ORDEN:
			if(null != (linea = br.readLine())){
				matriz = new double[Integer.parseInt(linea)][Integer.parseInt(linea)];
			}
			orden = Integer.parseInt(linea);
			//CARGAR MATRIZ TERM INDEP:
			int n = orden*orden;
			for(int i=0;i<n;i++){	
				linea=br.readLine();
				arraySplit= linea.split(" ");
				matriz[Integer.parseInt(arraySplit[0])][Integer.parseInt(arraySplit[1])]=Double.parseDouble(arraySplit[2]);
				}
			this.matrizCoeficientes=new MatrizMath();
			this.matrizCoeficientes.setComponentes(matriz);
			//CARGAR VECTOR SOLUCION:
			this.vectorTerminosIndependientes = new VectorMath(orden);
			vector=new double[orden];
			for(int i=0;i<orden;i++){
				linea=br.readLine();
				vector[i]=Double.parseDouble(linea);
			}
			this.vectorTerminosIndependientes.setComponentes(vector);
			
		} catch (Exception e) {
		}
		finally{
			if(fr !=null){
				try {
					fr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}


	
		//ARCHIVO OUT
		File archivoOut=null;
		FileReader frOut=null;
		BufferedReader brOut = null;
		String lineaOut="";
		Integer dimension=0;
		double[] vectorT = null;
		//ABRO ARCHIVO:
		try {
			archivoOut= new File(archOut);
			frOut=new FileReader(archivoOut);
			brOut=new BufferedReader(frOut);
			//CARGO VECTOR INCOGNITAS:
			lineaOut = brOut.readLine();
			dimension = Integer.parseInt(lineaOut);
			this.vectorIncognita = new VectorMath(dimension);
			vectorT=new double[dimension];
			for(int i=0;i<dimension;i++){
				lineaOut=brOut.readLine();
				vectorT[i]=Double.parseDouble(lineaOut);
			}
			this.vectorIncognita.setComponentes(vectorT);
			lineaOut = brOut.readLine();
			lineaOut = brOut.readLine();
			//CARGO ERROR:
			this.errorSel = Double.parseDouble(lineaOut);
	
		} catch (Exception e) {
		}
		finally{
			if(frOut !=null){
				try {
					frOut.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public boolean probarSel(){
		boolean respuesta=false;
		
		if ( this.errorSel < 10E-6)
			respuesta=true;
		else
			respuesta=false;
				
		return respuesta;
	}
	
}
