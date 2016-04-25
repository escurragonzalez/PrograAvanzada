package ecuacionesLineales;

import java.io.*;

public class MatrizMath {
	
	private int dimensionFil;
	private int dimensionCol;
	private float[][] componentes;
	
	public MatrizMath(){
	}
	
	public MatrizMath(int dimensionFil,int dimensionCol){
		this.dimensionFil = dimensionFil;
		this.dimensionCol = dimensionCol;
		this.componentes = new float[dimensionFil][dimensionCol];
	}
	
	public MatrizMath(String path){
		File archivo=null;
		BufferedReader br= null;
		FileReader fr= null;
		String linea;
		String[] arraySplit;
		float[][] matriz = null;
		try{
			archivo = new File(path);
			fr = new FileReader(archivo);
			br = new BufferedReader(fr);
			if(null != (linea = br.readLine())){
				arraySplit= linea.split(" ");
				matriz = new float[Integer.parseInt(arraySplit[0])][Integer.parseInt(arraySplit[1])];
				this.dimensionFil=Integer.parseInt(arraySplit[0]);
				this.dimensionCol=Integer.parseInt(arraySplit[1]);
			}
			while(null!= (linea= br.readLine())){
				arraySplit= linea.split(" ");
				matriz[Integer.parseInt(arraySplit[0])][Integer.parseInt(arraySplit[1])]=Float.parseFloat(arraySplit[2]);
			}
			this.componentes=matriz;
		}
		catch(Exception e){
			System.out.println("Error al construir matriz");
		}
		finally{
			try{                    
	            if( null != fr ){   
	               fr.close();     
	            }                  
	         }catch (Exception e2){ 
	            e2.printStackTrace();
	         }
		}
	}
	
	public void setComponentes(float[][] componentes){
		this.dimensionFil=componentes.length;
		this.dimensionCol=componentes[0].length;
		this.componentes=new float[this.dimensionFil][this.dimensionCol];
		for (int i = 0; i < this.dimensionFil; i++) {
			for (int j = 0; j < this.dimensionCol; j++) {
				this.componentes[i][j]=componentes[i][j];
			}
		}		
	}
	
	public int getDimensionFil() {
		return dimensionFil;
	}

	public int getDimensionCol() {
		return dimensionCol;
	}

	public float[][] getComponentes() {
		return this.clone().componentes;
	}
	
	public String  toString(){
		String resultado="";
		for(int i=0;i<this.getDimensionFil();i++){
			for(int j=0;j<this.getDimensionCol();j++){
				resultado+=this.getComponentes()[i][j]+" ";
			}
			resultado += "\n";
		}
		return resultado;
	}
	
	public MatrizMath clone(){
		MatrizMath matriz = new MatrizMath(this.getDimensionFil(),this.getDimensionCol());
		matriz.setComponentes(this.componentes);
		return matriz;
	}
	
	public boolean equals(Object matriz){
		if(matriz == null)
			return false;
		if(!(matriz instanceof MatrizMath))
			return false;
		MatrizMath nuevaMatriz = (MatrizMath) matriz;
		if(nuevaMatriz.getDimensionCol()!=this.getDimensionCol()|| nuevaMatriz.getDimensionFil()!=this.getDimensionFil())
			return false;
		for(int i=0;i<this.getDimensionFil();i++){
			for(int j=0;j<this.getDimensionCol();j++){
				if(this.getComponentes()[i][j]!=nuevaMatriz.getComponentes()[i][j]){
					return false;
				}
			}
		}
		return true;
	}
	
	private void productoDeUnaFila(float[][] matriz, int fila, float factor){
		try {
			if (fila < 0 || fila >= this.dimensionFil)
				throw new ArrayIndexOutOfBoundsException(" Error Valor Indice de Matriz: "+fila);
			for(int i=0;i<this.dimensionCol;i++){
				matriz[fila][i] *= (factor);
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
				}
		}
	private void intercambiarFilas(float[][] matriz, int filaOrigen, int filaDestino){
		try {
			if (filaOrigen < 0 || filaOrigen >= this.dimensionFil)
				throw new ArrayIndexOutOfBoundsException(" Error Valor Indice de Matriz: "+filaOrigen);
			if (filaDestino < 0 || filaDestino >= this.dimensionFil)
				throw new ArrayIndexOutOfBoundsException(" Error Valor Indice de Matriz: "+filaDestino);
			
			float auxiliar;
			
			for(int i=0;i<this.dimensionCol;i++){
				auxiliar = matriz[filaOrigen][i];
				matriz[filaOrigen][i]=matriz[filaDestino][i];
				matriz[filaDestino][i]=auxiliar;
				
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
				}
		}

	public void sumarFilas(float[][] matriz,int filaOrigen,int filaDestino){
		try {
			if (filaOrigen < 0 || filaOrigen >= this.dimensionFil)
				throw new ArrayIndexOutOfBoundsException(" Error Valor Indice de Matriz: "+filaOrigen);
			if (filaDestino < 0 || filaDestino >= this.dimensionFil)
				throw new ArrayIndexOutOfBoundsException(" Error Valor Indice de Matriz: "+filaDestino);
			
			for(int i=0;i<this.dimensionCol;i++){
				
				matriz[filaDestino][i]+=matriz[filaOrigen][i];
								
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
				}
		}
	
	public MatrizMath sumar(MatrizMath matriz){
	
		MatrizMath resultado = new MatrizMath(this.getDimensionFil(),this.getDimensionCol());
		
		try {
			
			if (this.getDimensionFil() != matriz.getDimensionFil() || this.getDimensionCol() != matriz.getDimensionCol())
				throw new DistDimException(" No se pueden sumar matrices de distinta dimension ");
			
			for(int i=0;i<this.getDimensionFil(); i++)
				for(int j=0;j<this.getDimensionCol();j++)
					resultado.componentes[i][j]=this.componentes[i][j]+matriz.componentes[i][j];
												
		   } catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
			}
		return resultado;		
	}
	
	public MatrizMath restar(MatrizMath matriz){
		
		MatrizMath resultado = new MatrizMath(this.getDimensionFil(),this.getDimensionCol());
		
		try {
			
			if (this.getDimensionFil() != matriz.getDimensionFil() || this.getDimensionCol() != matriz.getDimensionCol())
				throw new DistDimException(" No se pueden restar matrices de distinta dimension ");
			
			for(int i=0;i<this.getDimensionFil(); i++)
				for(int j=0;j<this.getDimensionCol();j++)
					resultado.componentes[i][j]=this.componentes[i][j]-matriz.componentes[i][j];
				
		   } catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
			}
		return resultado;		
	}
	
	public MatrizMath producto(float numero){
		
		MatrizMath resultado = new MatrizMath(this.getDimensionFil(),this.getDimensionCol());
			
		for(int i=0;i<this.getDimensionFil(); i++)
			for(int j=0;j<this.getDimensionCol();j++)
				resultado.componentes[i][j]=this.componentes[i][j]*numero;
					
		return resultado;		
	}
	
		public VectorMath producto(VectorMath vec){
		VectorMath resultado = null;

		
		try{
			if(this.getDimensionCol()!=vec.getDimension())
				throw new DistDimException(" Distinta Dimension entre Matriz y Vector ");
			
			resultado = new VectorMath(this.getDimensionCol());
			
			float[] componentes = new float[vec.getDimension()];
			

			for(int i = 0; i < this.getDimensionFil(); i++)
				for(int j = 0; j < this.getDimensionCol(); j++)
					componentes[i]+=this.getComponentes()[i][j]*vec.getComponentes()[j];
			
			resultado.setComponentes(componentes);
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		return resultado;
		}


	
	public MatrizMath producto(MatrizMath mat){
		MatrizMath matriz = null;
		
		try{
			if(this.getDimensionCol()!=mat.getDimensionFil())
				throw new DistDimException(" Distinta Dimension ");
			matriz = new MatrizMath(this.getDimensionFil(), mat.getDimensionCol());
			float[][] componentes = new float[this.getDimensionFil()][mat.getDimensionCol()];
			
			for (int i = 0; i < this.getDimensionFil(); i++) {
				for (int j = 0; j < mat.getDimensionCol(); j++) {
					for (int k = 0; k < this.getDimensionCol(); k++) {
						componentes[i][j]+=this.getComponentes()[i][k]+mat.getComponentes()[k][j];
					}
					
				}
				
			}
			matriz.setComponentes(componentes);
			return matriz;
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		return matriz;
				
	}
	
	
	private boolean intercambiarConRenglonNoNuloPorDebajo(float matriz[][], int filaColumna){
		try {
			if (filaColumna < 0 || filaColumna >= this.dimensionFil)
				throw new ArrayIndexOutOfBoundsException(" Error Valor Indice de Matriz: "+filaColumna);
			if (filaColumna < 0 || filaColumna >= this.dimensionCol)
				throw new ArrayIndexOutOfBoundsException(" Error Valor Indice de Matriz: "+filaColumna);
			
			
			for(int i=filaColumna+1;i<this.dimensionFil;i++){
				
				if (matriz[i][filaColumna]!=0) {
					this.intercambiarFilas(matriz, filaColumna, i);
					return true;
				}							
			}
			} catch (Exception e) {
				System.out.println(e.getMessage());
				}
		return false;
		}
	
	public boolean intercambiarConRenglonNoNuloPorArriba(float matriz[][], int filaColumna){
		try {
			if (filaColumna < 0 || filaColumna >= this.dimensionFil)
				throw new ArrayIndexOutOfBoundsException(" Error Valor Indice de Matriz: "+filaColumna);
			if (filaColumna < 0 || filaColumna >= this.dimensionCol)
				throw new ArrayIndexOutOfBoundsException(" Error Valor Indice de Matriz: "+filaColumna);
			
			for(int i=filaColumna-1;i >=0;i--){
				
				if (matriz[i][filaColumna]!=0) {
					this.intercambiarFilas(matriz, filaColumna, i);					
					return true;
				} 					
			}
			} catch (Exception e) {
				System.out.println(e.getMessage());
				}
			return false;
	}
	
	private void llevarACeroPosicionesPorDebajo(float[][] matriz ,int filaColumna){
		try {
			if (filaColumna < 0 || filaColumna >= this.dimensionFil)
				throw new ArrayIndexOutOfBoundsException(" Error Valor Indice de Matriz: "+filaColumna);
			if (filaColumna < 0 || filaColumna >= this.dimensionCol)
				throw new ArrayIndexOutOfBoundsException(" Error Valor Indice de Matriz: "+filaColumna);
			
			for(int i=filaColumna+1;i < this.dimensionFil ;i++){
				
				if (matriz[i][filaColumna]!=0) {
					float factorMultiplicacion = (matriz[i][filaColumna]/matriz[filaColumna][filaColumna]);
					this.diferenciaFilaConMultiploDeOtra(matriz,i,filaColumna,factorMultiplicacion);
				} 
								
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
				}
	}
	
	private void diferenciaFilaConMultiploDeOtra(float[][] matriz, int filaOrigen, int filaDestino, float factorMultiplicacion) {
		try {
			if (filaOrigen < 0 || filaOrigen >= this.dimensionFil)
				throw new ArrayIndexOutOfBoundsException(" Error Valor Indice de Matriz: "+filaOrigen);
			if (filaDestino < 0 || filaDestino >= this.dimensionFil)
				throw new ArrayIndexOutOfBoundsException(" Error Valor Indice de Matriz: "+filaDestino);
			
			float temp;
			
			for(int i=0;i<this.dimensionCol;i++){
				temp=(factorMultiplicacion)*matriz[filaDestino][i];
				matriz[filaOrigen][i]-=temp;								
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
				}
		}
		
	private void llevarACeroPosicionesPorArriba(float[][] matriz ,int filaColumna){
		try {
			if (filaColumna < 0 || filaColumna >= this.dimensionFil)
				throw new ArrayIndexOutOfBoundsException(" Error Valor Indice de Matriz: "+filaColumna);
			if (filaColumna < 0 || filaColumna >= this.dimensionCol)
				throw new ArrayIndexOutOfBoundsException(" Error Valor Indice de Matriz: "+filaColumna);
			
			for(int i=filaColumna-1;i >= 0 ;i--){
				
				if (matriz[i][filaColumna]!=0){ 
					float factorMultiplicacion = (matriz[i][filaColumna]/matriz[filaColumna][filaColumna]);
					this.diferenciaFilaConMultiploDeOtra(matriz,i,filaColumna,factorMultiplicacion);
				} 
								
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
				}
	}
	
	private float determinanteCuadrada(){//determinante matriz cuadrada por método de Gauss
		float deter = 1;
		float [][] matriz = this.clone().getComponentes();
				
		for(int i=0;i<this.dimensionCol;i++){
			if(matriz[i][i]==0){
				if(this.intercambiarConRenglonNoNuloPorDebajo(matriz, i)==true){
					deter *= (-1);
				}
			}
			this.llevarACeroPosicionesPorDebajo(matriz, i);
			deter*=matriz[i][i];
		}
				
		return deter;
	}
	
	public float determinante(){		
		try {
			if(this.dimensionCol!=this.dimensionFil){
				throw new UnsupportedOperationException(" No Hay Implementacion para Matrices no Cuadradas");
							}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return 0;
		}
		return this.determinanteCuadrada();
		  	
	}
	
	private void tratarDiagonalPrincipal(float[][] matriz){
		try {

			for (int i = 0; i < this.getDimensionFil(); i++) {
				if(matriz[i][i]==0){
					if(this.intercambiarConRenglonNoNuloPorDebajo(matriz, i)==false){
						throw new Exception(" No Se Puede Resolver La Inversa "+i);	
					}
				}
				this.llevarACeroPosicionesPorArriba(matriz, i);
				this.llevarACeroPosicionesPorDebajo(matriz, i);
				this.productoDeUnaFila(matriz, i, 1/(matriz[i][i]));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public MatrizMath invertir(){
		MatrizMath inversa=this.clone();
		float [][] matriz=inversa.adjuntaDerechaIdentidad();
		this.setComponentes(matriz);
		try {
			this.tratarDiagonalPrincipal(matriz);
		} catch (Exception e) {
			e.getMessage();
		}
		float[][] matrizInversa=this.tomarMatrizCuadradaALaDerecha(matriz);
		inversa.setComponentes(matrizInversa);
		return inversa;
	}
	
	private float[][] tomarMatrizCuadradaALaDerecha(float[][] matriz){
		float[][]matrizCuadrada=null;
		try {
			if (this.getDimensionCol()<this.getDimensionFil()) { 
				throw new DistDimException(" Se Intenta Operar Con Filas Mayores Que Columnas ");
			}
			matrizCuadrada=new float[this.getDimensionFil()][this.getDimensionFil()];
			for(int i=0;i<this.getDimensionFil();i++)
				for (int j = 0; j < this.getDimensionFil(); j++) {
					matrizCuadrada[i][j]=matriz[i][this.getDimensionCol()-this.dimensionFil+j];
				}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return matrizCuadrada;
	}
	
	private float[][] adjuntaDerechaIdentidad(){
		
		float[][] matriz = new float[this.getDimensionFil()][this.getDimensionCol()*2];
		
		for (int fila = 0; fila < matriz.length; fila++) {
			for (int col = 0; col < matriz[0].length; col++) {
				if(col>=this.getDimensionCol())
				{
					if ((col-fila)==this.getDimensionCol()) {
						matriz[fila][col]=1;
					}
					else {
						matriz[fila][col]=0;
					}
				}	
				else {
					matriz[fila][col]=this.getComponentes()[fila][col];	
				}
			}
		}
		return matriz;
	}
	
	public float normaDos(){
		
		float sumaCuadrados=0;
		
		for (int i = 0; i < this.componentes.length; i++) {
			for (int j = 0; j < this.componentes[0].length; j++) {
				sumaCuadrados += Math.pow(this.componentes[i][j],2);
			}
		}
		
		return (float)Math.sqrt(sumaCuadrados);
	}
	
}
	
