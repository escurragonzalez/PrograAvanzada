package ecuacionesLineales;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Probador {
	
	private MatrizMath matrizCoeficientes; //INPUT
	private VectorMath vectorTerminosIndependientes;//INPUT
	private VectorMath vectorIncognita; //OUTPUT
	private float errorSel; //OUTPUT
	
	public Probador(){
		//ARCHIVO IN
		File archivo=null;
		FileReader fr=null;
		BufferedReader br = null;
		String linea="";
		String[] arraySplit;
		float[][] matriz = null;
		Integer orden=0;
		float[] vector = null;
		try {
			//ABRO ARCHIVO:
			archivo= new File("sel.in");
			fr=new FileReader(archivo);
			br=new BufferedReader(fr);
			//CARGO ORDEN:
			if(null != (linea = br.readLine())){
				matriz = new float[Integer.parseInt(linea)][Integer.parseInt(linea)];
			}
			orden = Integer.parseInt(linea);
			//CARGAR MATRIZ TERM INDEP:
			int n = orden*orden;
			for(int i=0;i<n;i++){	
				linea=br.readLine();
				arraySplit= linea.split(" ");
				matriz[Integer.parseInt(arraySplit[0])][Integer.parseInt(arraySplit[1])]=Float.parseFloat(arraySplit[2]);
				}
			this.matrizCoeficientes=new MatrizMath();
			this.matrizCoeficientes.setComponentes(matriz);
			//CARGAR VECTOR SOLUCION:
			this.vectorTerminosIndependientes = new VectorMath(orden);
			vector=new float[orden];
			for(int i=0;i<orden;i++){
				linea=br.readLine();
				vector[i]=Float.parseFloat(linea);
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
		float[] vectorT = null;
		//ABRO ARCHIVO:
		try {
			archivoOut= new File("solucion.out");
			frOut=new FileReader(archivoOut);
			brOut=new BufferedReader(frOut);
			//CARGO VECTOR INCOGNITAS:
			lineaOut = brOut.readLine();
			dimension = Integer.parseInt(lineaOut);
			this.vectorIncognita = new VectorMath(dimension);
			vectorT=new float[dimension];
			for(int i=0;i<dimension;i++){
				lineaOut=brOut.readLine();
				vectorT[i]=Float.parseFloat(lineaOut);
			}
			this.vectorIncognita.setComponentes(vectorT);
			lineaOut = brOut.readLine();
			lineaOut = brOut.readLine();
			//CARGO ERROR:
			this.errorSel = Float.parseFloat(lineaOut);
	
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
		VectorMath vecTermIndepPrima = null;
		
		float errorTermIndep;
		
		vecTermIndepPrima = this.matrizCoeficientes.producto(this.vectorIncognita);
		
		errorTermIndep = (vecTermIndepPrima.restar(this.vectorTerminosIndependientes)).normaDos();
		
		/*System.out.println("VECTERMINDEP: " + vecTermIndepPrima.toString());
		System.out.println("RESTA: " + vecTermIndepPrima.restar(this.vectorTerminosIndependientes));
		System.out.println("NORMA 2: " + (vecTermIndepPrima.restar(this.vectorTerminosIndependientes)).normaDos());
		System.out.println("ERRORTERMINDEP: " + errorTermIndep);*/
		
		if (errorTermIndep <= this.errorSel)
			respuesta=true;
		else
			respuesta=false;
				
		return respuesta;
	}
	
}
