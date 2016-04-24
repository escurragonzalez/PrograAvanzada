package ecuacionesLineales;

import java.io.*;

public class Sel {

	private MatrizMath matrizCoeficientes;
	private VectorMath vectorIncognita;
	private VectorMath vectorTerminosIndependientes;
	
	public Sel(){
		File archivo=null;
		FileReader fr=null;
		BufferedReader br = null;
		String linea="";
		String[] arraySplit;
		float[][] matriz = null;
		Integer orden=0;
		float[] vector = null;
		try {
			archivo= new File("sel.in");
			fr=new FileReader(archivo);
			br=new BufferedReader(fr);
			if(null != (linea = br.readLine())){
				matriz = new float[Integer.parseInt(linea)][Integer.parseInt(linea)];
			}
			orden = Integer.parseInt(linea);
			int n = orden*orden;
			for(int i=0;i<n;i++){	
				linea=br.readLine();
				arraySplit= linea.split(" ");
				matriz[Integer.parseInt(arraySplit[0])][Integer.parseInt(arraySplit[1])]=Float.parseFloat(arraySplit[2]);
				}
			this.matrizCoeficientes=new MatrizMath();
			this.matrizCoeficientes.setComponentes(matriz);
			this.vectorTerminosIndependientes = new VectorMath(orden);
			vector=new float[orden];
			for(int i=0;i<orden;i++){
				linea=br.readLine();
				vector[i]=Float.parseFloat(linea);
			}
			this.vectorTerminosIndependientes.setComponentes(vector);
			this.vectorIncognita= new VectorMath(orden);
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
	}
	
	public String toString(){
		String resultado="";
		resultado += "Matriz de Coeficientes: \n"+this.matrizCoeficientes.toString() + "\n";
		resultado += "Vector de Incognitas: \n"+this.vectorIncognita.toString()+ "\n";
		resultado += "Vector Solucion: \n" +this.vectorTerminosIndependientes.toString()+ "\n";		
		return resultado;
	}
	
	public Sel clone(){
		Sel nuevo = new Sel();
		nuevo.matrizCoeficientes = this.matrizCoeficientes.clone();
		nuevo.vectorIncognita = this.vectorIncognita.clone();
		nuevo.vectorTerminosIndependientes = this.vectorTerminosIndependientes.clone();
		return nuevo;
	}
	
	public void resolver(){
		FileWriter fichero = null;
		PrintWriter pw = null;
		MatrizMath matrizInvertida = null;
		VectorMath vectorsolucion = null;
		try {
			matrizInvertida = this.matrizCoeficientes.invertir();
			vectorsolucion = matrizInvertida.producto(this.vectorTerminosIndependientes);
			this.vectorIncognita.setComponentes(vectorsolucion.getComponentes());
			fichero = new FileWriter("sel.out");
			pw = new PrintWriter(fichero);
			pw.println(this.vectorIncognita.getDimension());
			for(int i=0;i<this.vectorIncognita.getDimension();i++){
				pw.println(this.vectorIncognita.getComponentes()[i]);
			}
			pw.println();
			pw.print("Error: "+ calculoDeError());
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
		if( null!=fichero){
			try {
				fichero.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		}
	}
	
	private float calculoDeError(){
		float error=0;
		VectorMath resultado = new VectorMath(this.vectorIncognita.getDimension());
		VectorMath diferencia = new VectorMath(this.vectorIncognita.getDimension());
		resultado = this.matrizCoeficientes.producto(this.vectorIncognita);
		diferencia = this.vectorTerminosIndependientes.restar(resultado);
		error = diferencia.getComponentes()[0];
		for(int i=0;i<this.vectorIncognita.getDimension();i++){
			if(error>Math.abs(diferencia.getComponentes()[i])){
				error=diferencia.getComponentes()[i];
			}
		}
		return error;
	}
}

